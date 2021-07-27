package com.epam.training.service.delivery.service;

import com.epam.training.service.delivery.model.DeliveryAggregate;
import org.springframework.stereotype.Component;

@Component
public class DeliveryAggregateFactory {
  public DeliveryAggregate newInstance() {
    return new DeliveryAggregate();
  }
}
