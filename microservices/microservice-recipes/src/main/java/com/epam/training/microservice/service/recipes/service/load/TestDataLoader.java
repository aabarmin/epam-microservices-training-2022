package com.epam.training.microservice.service.recipes.service.load;

import com.epam.training.microservice.service.recipes.model.Doctor;
import com.epam.training.microservice.service.recipes.model.Recipe;
import com.epam.training.microservice.service.recipes.model.RecipeLine;
import com.epam.training.microservice.service.recipes.model.Recipient;
import com.epam.training.microservice.service.recipes.repository.DoctorRepository;
import com.epam.training.microservice.service.recipes.service.drugs.DrugService;
import com.epam.training.microservice.service.recipes.repository.RecipientRepository;
import com.epam.training.microservice.service.recipes.service.recipe.RecipeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {
    @Value("classpath:test-data/doctor-and-recipies.json")
    private Resource doctorResource;

    private final ObjectMapper objectMapper;

    private final DoctorRepository doctorRepository;

    private final RecipientRepository recipientRepository;

    private final RecipeService recipeService;

    private final DrugService drugService;

    @Override
    public void run(String... args) throws Exception {
      @Cleanup final InputStream contentStream = doctorResource.getInputStream();
      objectMapper
          .readValue(contentStream, new TypeReference<List<DoctorLoadModel>>() {})
          .forEach(this::importDoctorAndRecipe);
    }

    private void importDoctorAndRecipe(DoctorLoadModel model) {
        final Doctor doctor = importDoctor(model);
        for (RecipeLoadModel recipeModel : model.getRecipes()) {
            final Recipient recipient = importRecipient(recipeModel);

            final Recipe recipe = recipeService.find(
                    doctor,
                    recipient,
                    recipeModel.getIssueDate()
            )
                    .orElseGet(() -> {
                        final Recipe newRecipe = new Recipe();
                        newRecipe.setDoctor(doctor);
                        newRecipe.setRecipient(recipient);
                        newRecipe.setIssueDate(recipeModel.getIssueDate());
                        return newRecipe;
                    });

            final Set<RecipeLine> recipeLines = recipeModel.getContent()
                    .stream()
                    .map(line -> {
                        final RecipeLine newLine = new RecipeLine();
                        newLine.setAmount(line.getAmount());
                        newLine.setInstruction(line.getInstruction());
                        newLine.setDrugId(
                                drugService.getDrugIdByName(line.getDrug()).orElse(-1L)
                        );
                        newLine.setRecipe(recipe);
                        return newLine;
                    })
                    .collect(Collectors.toSet());

            recipe.getLines().addAll(recipeLines);

            recipeService.save(recipe);
        }
    }

    private Doctor importDoctor(DoctorLoadModel model) {
        final Doctor doctor = doctorRepository.findDoctorByFirstNameAndLastName(
                model.getDoctor().getFirstName(),
                model.getDoctor().getLastName()
        )
                .orElseGet(() -> {
                    final Doctor newDoctor = new Doctor();
                    newDoctor.setFirstName(model.getDoctor().getFirstName());
                    newDoctor.setLastName(model.getDoctor().getLastName());
                    return newDoctor;
                });

        return doctorRepository.save(doctor);
    }

    private Recipient importRecipient(RecipeLoadModel recipeModel) {
        final Recipient recipient = recipientRepository.findRecipientByFirstNameAndLastName(
                recipeModel.getRecipient().getFirstName(),
                recipeModel.getRecipient().getLastName()
        )
                .orElseGet(() -> {
                    final Recipient newRecipient = new Recipient();
                    newRecipient.setFirstName(recipeModel.getRecipient().getFirstName());
                    newRecipient.setLastName(recipeModel.getRecipient().getLastName());
                    return newRecipient;
                });

        return recipientRepository.save(recipient);
    }
}
