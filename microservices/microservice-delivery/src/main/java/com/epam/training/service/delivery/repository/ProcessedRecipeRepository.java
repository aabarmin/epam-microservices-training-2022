package com.epam.training.service.delivery.repository;

import com.epam.training.service.delivery.model.ProcessedRecipe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedRecipeRepository extends JpaRepository<ProcessedRecipe, Long> {
  Optional<ProcessedRecipe> findProcessedRecipeByRecipeId(Long recipeId);
}
