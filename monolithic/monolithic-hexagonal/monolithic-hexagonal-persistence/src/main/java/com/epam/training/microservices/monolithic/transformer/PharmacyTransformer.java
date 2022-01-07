package com.epam.training.microservices.monolithic.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.jpa.entity.pharmacy.PharmacyEntity;
import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface PharmacyTransformer extends Transformer<Pharmacy, PharmacyEntity> {
  @Override
  default PharmacyEntity newEntity() {
    return new PharmacyEntity();
  }
}
