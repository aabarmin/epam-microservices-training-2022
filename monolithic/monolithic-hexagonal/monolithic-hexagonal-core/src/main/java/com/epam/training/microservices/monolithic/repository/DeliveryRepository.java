package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.repository.CrudRepository;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
