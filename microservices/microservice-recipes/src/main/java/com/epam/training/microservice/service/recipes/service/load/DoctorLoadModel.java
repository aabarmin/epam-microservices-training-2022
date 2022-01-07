package com.epam.training.microservice.service.recipes.service.load;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DoctorLoadModel {
  private Person doctor;
  private List<RecipeLoadModel> recipes = new ArrayList<>();
}
