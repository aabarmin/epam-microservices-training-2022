package com.epam.training.service.delivery.service;

import com.epam.training.service.delivery.model.ProcessedRecipe;
import com.epam.training.service.delivery.model.message.RecipeModel;
import com.epam.training.service.delivery.repository.ProcessedRecipeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RecipeProcessor {
  @Autowired
  private ProcessedRecipeRepository repository;

  @Transactional
  public boolean process(RecipeModel recipeModel) {
    final Optional<ProcessedRecipe> processedOptional =
        repository.findProcessedRecipeByRecipeId(recipeModel.getId());

    if (processedOptional.isPresent()) {
      // do nothing, this recipe has already been processed
      return false;
    }

    final ProcessedRecipe processed = new ProcessedRecipe();
    processed.setRecipeId(recipeModel.getId());
    repository.save(processed);

    System.out.printf("Do some real processing");

    return true;
  }


}
