package com.epam.training.service.delivery.event;

import com.epam.training.service.delivery.model.DeliveryAggregate;

public interface DeliveryEvent {
  void process(DeliveryAggregate aggregate);

  void setId(Long id);
  Long getId();
}
