package com.epam.training.microservices.monolithic.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.jpa.entity.disease.SymptomEntity;
import com.epam.training.microservices.monolithic.model.disease.Symptom;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface SymptomTransformer extends Transformer<Symptom, SymptomEntity> {
  @Override
  default SymptomEntity newEntity() {
    return new SymptomEntity();
  }
}
