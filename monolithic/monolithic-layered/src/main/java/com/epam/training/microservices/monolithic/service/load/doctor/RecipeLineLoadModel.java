package com.epam.training.microservices.monolithic.service.load.doctor;

import lombok.Data;

@Data
public class RecipeLineLoadModel {
  private String drug;
  private Long amount;
  private String instruction;
}
