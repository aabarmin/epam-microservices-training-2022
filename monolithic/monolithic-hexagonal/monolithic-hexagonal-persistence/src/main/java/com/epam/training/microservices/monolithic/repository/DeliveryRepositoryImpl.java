package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.jpa.entity.delivery.DeliveryEntity;
import com.epam.training.microservices.monolithic.jpa.repository.DeliveryJpaRepository;
import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.transformer.DeliveryTransformer;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryRepositoryImpl extends BasicCrudRepository<Delivery, DeliveryEntity, Long>
    implements DeliveryRepository {

  @Getter
  @Autowired
  private DeliveryJpaRepository jpaRepository;

  @Getter
  @Autowired
  private DeliveryTransformer transformer;
}
