package com.epam.training.microservices.monolithic.service.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
