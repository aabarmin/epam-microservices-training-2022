package com.epam.training.microservice.service.recipes.service.recipe;

import com.epam.training.microservice.service.recipes.model.Doctor;
import com.epam.training.microservice.service.recipes.model.OutgoingRecipe;
import com.epam.training.microservice.service.recipes.model.Recipe;
import com.epam.training.microservice.service.recipes.model.Recipient;
import com.epam.training.microservice.service.recipes.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private OutgoingRecipeService outgoingRecipeService;

//    @Autowired
//    private StreamBridge streamBridge;

    @Transactional
    public Recipe save(Recipe recipe) {
//        final Message<Recipe> message = MessageBuilder.withPayload(recipe).build();
//        streamBridge.send("deliveryNotificator-out-0", message);

        final Recipe savedRecipe = recipeRepository.save(recipe);

        final OutgoingRecipe outgoingRecipe = outgoingRecipeService.findOrCreate(savedRecipe);
        checkArgument(outgoingRecipe != null, "Outgoing recipe wasn't created");

        return savedRecipe;
    }

    public Optional<Recipe> find(Doctor doctor,
                                 Recipient recipient,
                                 LocalDate issueDate) {
        return recipeRepository.findRecipeByDoctorAndRecipientAndIssueDate(doctor, recipient, issueDate);
    }
}
