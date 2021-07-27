package com.epam.training.service.delivery.service;

import com.epam.training.service.delivery.event.AddDeliveryLineEvent;
import com.epam.training.service.delivery.event.ChangeFieldEvent;
import com.epam.training.service.delivery.event.DeliveryEvent;
import com.epam.training.service.delivery.model.DeliveryAggregate;
import com.epam.training.service.delivery.repository.DeliveryRepository;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
  @Autowired
  private DeliveryRepository repository;

  public Optional<DeliveryAggregate> findOne(Long id) {
    return repository.findOne(id);
  }
}
