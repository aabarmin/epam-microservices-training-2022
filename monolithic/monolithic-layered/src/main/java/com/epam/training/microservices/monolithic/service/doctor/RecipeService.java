package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import java.time.LocalDate;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
  private final RecipeRepository recipeRepository;

  public Recipe save(Recipe recipe) {
    return recipeRepository.save(recipe);
  }

  public Optional<Recipe> find(Doctor doctor,
                               Recipient recipient,
                               LocalDate issueDate) {

    return recipeRepository
        .findRecipeByDoctorAndRecipientAndIssueDate(doctor, recipient, issueDate);
  }
}
