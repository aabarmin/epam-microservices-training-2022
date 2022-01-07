package com.epam.training.microservices.monolithic.loader.doctor;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class DoctorLoadModel {
  private Person doctor;
  private List<RecipeLoadModel> recipes = Lists.newArrayList();
}
