package com.epam.training.microservices.monolithic.web.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.web.model.DiseaseModel;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DiseaseModelTransformer {
  DiseaseModel toModel(Disease disease);
}
