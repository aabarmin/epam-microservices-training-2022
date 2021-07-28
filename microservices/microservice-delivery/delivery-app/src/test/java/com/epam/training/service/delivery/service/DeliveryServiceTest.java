//package com.epam.training.service.delivery.service;
//
//import com.epam.training.service.delivery.model.DeliveryAggregate;
//import com.epam.training.service.delivery.model.DeliveryStatus;
//import com.epam.training.service.delivery.repository.DeliveryRepository;
//import java.util.Optional;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//class DeliveryServiceTest {
//  @Autowired
//  private DeliveryRepository deliveryRepository;
//
//  @Autowired
//  private DeliveryService deliveryService;
//
//  @Autowired
//  private DeliveryAggregateFactory aggregateFactory;
//
//  @Test
//  void save_and_read() {
//    final DeliveryAggregate aggregate = aggregateFactory.newInstance();
//    aggregate.setAddressLine("Address line");
//    aggregate.setPharmacyId(42L);
//    aggregate.setStatus(DeliveryStatus.COMPLETED);
//
//    final DeliveryAggregate savedAggregate = deliveryRepository.save(aggregate);
//
//    final Optional<DeliveryAggregate> loadedAggregate = deliveryService.findOne(savedAggregate.getId());
//
//    assertThat(loadedAggregate)
//        .isNotNull();
//  }
//}