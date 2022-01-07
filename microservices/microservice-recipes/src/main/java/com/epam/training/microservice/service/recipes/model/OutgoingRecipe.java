package com.epam.training.microservice.service.recipes.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
