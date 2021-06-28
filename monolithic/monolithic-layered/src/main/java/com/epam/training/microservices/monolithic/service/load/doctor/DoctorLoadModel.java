package com.epam.training.microservices.monolithic.service.load.doctor;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;

@Data
public class DoctorLoadModel {
  private Person doctor;
  private List<RecipeLoadModel> recipes = Lists.newArrayList();
}
