package com.epam.training.microservices.monolithic.jpa.repository;

import com.epam.training.microservices.monolithic.jpa.entity.recipie.DoctorEntity;
import com.epam.training.microservices.monolithic.jpa.entity.recipie.RecipeEntity;
import com.epam.training.microservices.monolithic.jpa.entity.recipie.RecipientEntity;
import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeJpaRepository extends JpaRepository<RecipeEntity, Long> {
  Optional<RecipeEntity> findRecipeByDoctorAndRecipientAndIssueDate(
      DoctorEntity doctor,
      RecipientEntity recipient,
      LocalDate issueDate
  );
}
