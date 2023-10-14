package com.epam.training.service.delivery.service;

import com.epam.training.service.delivery.model.DeliveryAggregate;
import com.epam.training.service.delivery.repository.DeliveryRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {
  private final DeliveryRepository repository;

  public Optional<DeliveryAggregate> findOne(Long id) {
    return repository.findOne(id);
  }
}
