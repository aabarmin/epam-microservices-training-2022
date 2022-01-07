package com.epam.training.microservices.monolithic.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.jpa.entity.drug.DrugEntity;
import com.epam.training.microservices.monolithic.model.drug.Drug;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DrugTransformer extends Transformer<Drug, DrugEntity> {
  @Override
  default DrugEntity newEntity() {
    return new DrugEntity();
  }
}
