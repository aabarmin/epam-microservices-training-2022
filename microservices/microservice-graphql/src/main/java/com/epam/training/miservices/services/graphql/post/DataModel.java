package com.epam.training.miservices.services.graphql.post;

import lombok.Data;

@Data
public class DataModel {
  private Long id;
  private String firstName;
  private String lastName;
  private String title;
  private String text;
}
