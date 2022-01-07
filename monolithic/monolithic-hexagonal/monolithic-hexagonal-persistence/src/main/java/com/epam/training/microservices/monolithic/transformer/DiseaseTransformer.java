package com.epam.training.microservices.monolithic.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.jpa.entity.disease.DiseaseEntity;
import com.epam.training.microservices.monolithic.model.disease.Disease;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DiseaseTransformer extends Transformer<Disease, DiseaseEntity> {
  @Override
  default DiseaseEntity newEntity() {
    return new DiseaseEntity();
  }
}
