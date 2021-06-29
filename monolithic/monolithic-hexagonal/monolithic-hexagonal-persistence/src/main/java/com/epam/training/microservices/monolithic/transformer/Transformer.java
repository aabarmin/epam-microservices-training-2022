package com.epam.training.microservices.monolithic.transformer;

import org.mapstruct.MappingTarget;

public interface Transformer<MODEL, ENTITY> {
  void toEntity(@MappingTarget ENTITY entity, MODEL model);

  MODEL toModel(ENTITY entity);

  ENTITY newEntity();
}
