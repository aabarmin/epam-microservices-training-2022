package com.epam.training.microservices.monolithic.service.load.doctor;

import com.google.common.collect.Lists;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class RecipeLoadModel {
  private LocalDate issueDate;
  private Person recipient;
  private List<RecipeLineLoadModel> content = Lists.newArrayList();
}
