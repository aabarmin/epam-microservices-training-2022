package com.epam.training.microservice.service.recipes.controller;

import com.epam.training.microservice.service.recipes.model.DrugModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecipeRestLineModel {
  private DrugModel drugModel;
  private Long amount;
  private String instruction;
}
