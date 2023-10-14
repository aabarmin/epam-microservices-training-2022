package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import com.epam.training.microservices.monolithic.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService implements CrudService<Delivery> {
  private final DeliveryRepository deliveryRepository;

  @Override
  public CrudRepository<Delivery, Long> getRepository() {
    return deliveryRepository;
  }
}
