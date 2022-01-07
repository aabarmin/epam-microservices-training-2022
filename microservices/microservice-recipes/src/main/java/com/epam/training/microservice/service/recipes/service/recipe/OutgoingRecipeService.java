package com.epam.training.microservice.service.recipes.service.recipe;

import com.epam.training.microservice.service.recipes.model.OutgoingRecipe;
import com.epam.training.microservice.service.recipes.model.Recipe;
import com.epam.training.microservice.service.recipes.repository.OutgoingRecipeRepository;
import java.time.LocalDateTime;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutgoingRecipeService {
  @Autowired
  private OutgoingRecipeRepository repository;

  public OutgoingRecipe findOrCreate(final Recipe recipe) {
    return repository.findOutgoingRecipeByRecipeAndSent(recipe, false)
        .orElseGet(() -> {
          final OutgoingRecipe outgoingRecipe = new OutgoingRecipe();
          outgoingRecipe.setRecipe(recipe);
          return repository.save(outgoingRecipe);
        });
  }

  public Collection<OutgoingRecipe> findUnprocessed() {
    return repository.findOutgoingRecipesBySent(false);
  }

  public OutgoingRecipe markSent(OutgoingRecipe recipe) {
    recipe.setSent(true);
    recipe.setSendDate(LocalDateTime.now());
    return repository.save(recipe);
  }
}
