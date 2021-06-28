package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
  Optional<Recipe> findRecipeByDoctorAndRecipientAndIssueDate(
      Doctor doctor,
      Recipient recipient,
      LocalDate issueDate
  );
}
