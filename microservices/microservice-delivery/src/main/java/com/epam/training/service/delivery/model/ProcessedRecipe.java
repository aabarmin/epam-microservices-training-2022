package com.epam.training.service.delivery.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "processed_recipes")
public class ProcessedRecipe {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long recipeId;
}
