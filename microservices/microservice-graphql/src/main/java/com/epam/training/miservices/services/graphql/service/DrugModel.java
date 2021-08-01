package com.epam.training.miservices.services.graphql.service;

import lombok.Data;

@Data
public class DrugModel {
  private Long id;
  private String name;
  private String description;
  private String available;
}
