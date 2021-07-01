package com.epam.training.microservice.service.recipes.repository;

import com.epam.training.microservice.service.recipes.model.Doctor;
import com.epam.training.microservice.service.recipes.model.Recipe;
import com.epam.training.microservice.service.recipes.model.Recipient;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Optional<Recipe> findRecipeByDoctorAndRecipientAndIssueDate(
            Doctor doctor,
            Recipient recipient,
            LocalDate issueDate
    );
}
