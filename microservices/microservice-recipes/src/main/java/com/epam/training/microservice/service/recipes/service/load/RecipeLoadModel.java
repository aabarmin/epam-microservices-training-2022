package com.epam.training.microservice.service.recipes.service.load;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class RecipeLoadModel {
  private LocalDate issueDate;
  private Person recipient;
  private List<RecipeLineLoadModel> content = new ArrayList<>();
}
