package com.epam.training.microservices.monolithic.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.jpa.entity.recipie.DoctorEntity;
import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DoctorTransformer extends Transformer<Doctor, DoctorEntity> {
  @Override
  default DoctorEntity newEntity() {
    return new DoctorEntity();
  }
}
