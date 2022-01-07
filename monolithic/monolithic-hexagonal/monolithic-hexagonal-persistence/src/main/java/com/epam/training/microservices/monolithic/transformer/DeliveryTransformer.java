package com.epam.training.microservices.monolithic.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.jpa.entity.delivery.DeliveryEntity;
import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface DeliveryTransformer extends Transformer<Delivery, DeliveryEntity> {
  @Override
  default DeliveryEntity newEntity() {
    return new DeliveryEntity();
  }
}
