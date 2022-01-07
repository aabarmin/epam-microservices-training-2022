package com.epam.training.microservices.monolithic.transformer;

import org.mapstruct.MappingTarget;

public interface Transformer<MODEL, ENTITY> {
  default ENTITY toEntity(MODEL model) {
    final ENTITY entity = newEntity();
    toEntity(entity, model);
    return entity;
  }

  void toEntity(@MappingTarget ENTITY entity, MODEL model);

  MODEL toModel(ENTITY entity);

  ENTITY newEntity();
}
