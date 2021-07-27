package com.epam.training.service.delivery.service;

import com.epam.training.service.delivery.event.DeliveryEvent;
import com.epam.training.service.delivery.model.DeliveryAggregate;

public interface DeliveryEventApplier {
  boolean supports(DeliveryEvent event);

  void apply(DeliveryAggregate aggregate, DeliveryEvent event);
}
