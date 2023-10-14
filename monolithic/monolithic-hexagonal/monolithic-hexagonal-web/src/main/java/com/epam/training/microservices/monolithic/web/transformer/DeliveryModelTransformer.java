package com.epam.training.microservices.monolithic.web.transformer;

import com.epam.training.microservices.monolithic.config.MapperConfiguration;
import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.web.model.DeliveryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfiguration.class)
public interface DeliveryModelTransformer {
  @Mapping(target = "pharmacyName", source = "pharmacy.name")
  DeliveryModel toModel(Delivery delivery);
}
