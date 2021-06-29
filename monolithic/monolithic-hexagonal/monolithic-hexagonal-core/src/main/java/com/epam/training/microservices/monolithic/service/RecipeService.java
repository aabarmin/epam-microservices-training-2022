package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import com.epam.training.microservices.monolithic.repository.RecipeRepository;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
  @Autowired
  private RecipeRepository recipeRepository;

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
