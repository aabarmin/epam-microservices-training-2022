package com.epam.training.microservices.monolithic.transformer;

import com.epam.training.microservices.monolithic.jpa.entity.delivery.DeliveryEntity;
import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryTransformer extends Transformer<Delivery, DeliveryEntity> {
  @Override
  default DeliveryEntity newEntity() {
    return new DeliveryEntity();
  }
}
