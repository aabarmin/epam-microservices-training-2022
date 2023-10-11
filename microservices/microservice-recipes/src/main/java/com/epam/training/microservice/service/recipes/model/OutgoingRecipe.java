package com.epam.training.microservice.service.recipes.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "outgoing_recipes")
public class OutgoingRecipe {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JoinColumn(name = "recipe_id")
  @OneToOne(fetch = FetchType.EAGER)
  private Recipe recipe;

  private LocalDateTime createdDate = LocalDateTime.now();
  private LocalDateTime sendDate;
  private boolean sent = false;
}
