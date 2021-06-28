package com.epam.training.microservices.monolithic.service.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService implements CrudService<Delivery> {
  @Autowired
  private DeliveryRepository deliveryRepository;

  @Override
  public JpaRepository<Delivery, Long> getRepository() {
    return deliveryRepository;
  }
}
