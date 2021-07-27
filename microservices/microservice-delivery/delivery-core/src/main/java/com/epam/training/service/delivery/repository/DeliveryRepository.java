package com.epam.training.service.delivery.repository;

import com.epam.training.service.delivery.model.DeliveryAggregate;
import java.util.Optional;

public interface DeliveryRepository {
  Optional<DeliveryAggregate> findOne(Long id);

  DeliveryAggregate save(DeliveryAggregate save);
}
