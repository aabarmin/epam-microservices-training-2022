package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.jpa.entity.recipie.RecipeEntity;
import com.epam.training.microservices.monolithic.jpa.repository.RecipeJpaRepository;
import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import com.epam.training.microservices.monolithic.transformer.DoctorTransformer;
import com.epam.training.microservices.monolithic.transformer.RecipeTransformer;
import com.epam.training.microservices.monolithic.transformer.RecipientTransformer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RecipeRepositoryImpl
    extends BasicCrudRepository<Recipe, RecipeEntity, Long>
    implements RecipeRepository {

  @Getter
  private final RecipeJpaRepository jpaRepository;

  @Getter
  private final RecipeTransformer transformer;

  private final DoctorTransformer doctorTransformer;
  private final RecipientTransformer recipientTransformer;

  @Override
  public Optional<Recipe> findRecipeByDoctorAndRecipientAndIssueDate(Doctor doctor, Recipient recipient, LocalDate issueDate) {
    return jpaRepository.findRecipeByDoctorAndRecipientAndIssueDate(
        doctorTransformer.toEntity(doctor),
        recipientTransformer.toEntity(recipient),
        issueDate
    ).map(transformer::toModel);
  }
}
