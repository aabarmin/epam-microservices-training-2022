package com.epam.training.microservices.monolithic.web.model;

import lombok.Data;

@Data
public class DiseaseModel {
  private Long id;
  private String name;
  private String description;
}
