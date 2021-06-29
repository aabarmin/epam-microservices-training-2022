package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import java.time.LocalDate;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
  Optional<Recipe> findRecipeByDoctorAndRecipientAndIssueDate(
      Doctor doctor,
      Recipient recipient,
      LocalDate issueDate
  );
}
