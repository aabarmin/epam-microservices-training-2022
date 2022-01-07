package com.epam.training.microservice.service.recipes.controller;

import com.epam.training.microservice.service.recipes.model.Doctor;
import com.epam.training.microservice.service.recipes.model.Recipient;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeRestModel {
  private Long id;
  private Doctor doctor;
  private Recipient recipient;
  @Builder.Default
  private Set<RecipeRestLineModel> lines = new HashSet<>();
  private LocalDate issueDate;
}
