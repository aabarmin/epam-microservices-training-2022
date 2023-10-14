package com.epam.training.microservices.monolithic.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.jpa.entity.recipie.RecipientEntity;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface RecipientTransformer extends Transformer<Recipient, RecipientEntity> {
  @Override
  default RecipientEntity newEntity() {
    return new RecipientEntity();
  }
}
