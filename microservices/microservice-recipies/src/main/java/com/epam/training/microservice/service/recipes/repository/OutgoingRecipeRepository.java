package com.epam.training.microservice.service.recipes.repository;

import com.epam.training.microservice.service.recipes.model.OutgoingRecipe;
import com.epam.training.microservice.service.recipes.model.Recipe;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutgoingRecipeRepository extends JpaRepository<OutgoingRecipe, Long> {
  Optional<OutgoingRecipe> findOutgoingRecipeByRecipeAndSent(Recipe recipe, boolean send);

  Collection<OutgoingRecipe> findOutgoingRecipesBySent(boolean send);
}
