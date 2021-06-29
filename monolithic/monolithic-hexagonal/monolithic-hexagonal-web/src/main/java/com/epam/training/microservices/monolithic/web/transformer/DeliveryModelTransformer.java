package com.epam.training.microservices.monolithic.web.transformer;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.web.model.DeliveryModel;
import org.springframework.stereotype.Component;

@Component
public class DeliveryModelTransformer {
  public DeliveryModel toModel(Delivery delivery) {
    return DeliveryModel.builder()
        .id(delivery.getId())
        .addressLine(delivery.getAddressLine())
        .pharmacyName(delivery.getPharmacy().getName())
        .status(delivery.getStatus())
        .build();
  }
}
