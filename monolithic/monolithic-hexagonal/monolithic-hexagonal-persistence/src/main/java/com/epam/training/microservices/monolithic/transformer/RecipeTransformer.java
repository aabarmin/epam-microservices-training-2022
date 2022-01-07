package com.epam.training.microservices.monolithic.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.jpa.entity.recipie.RecipeEntity;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface RecipeTransformer extends Transformer<Recipe, RecipeEntity> {
  @Override
  default RecipeEntity newEntity() {
    return new RecipeEntity();
  }
}
