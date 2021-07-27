package com.epam.training.service.delivery.model;

import com.epam.training.service.delivery.event.DeliveryEvent;
import com.epam.training.service.delivery.service.DeliveryAggregateFactory;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class DeliveryAggregateTest {
  @InjectMocks
  DeliveryAggregateFactory factory;

  @Test
  void createAndChangeAggregate() {
    final DeliveryAggregate aggregate = factory.newInstance();
    final DeliveryLine deliveryLine = new DeliveryLine();
    deliveryLine.setId(10L);

    aggregate.setAddressLine("Some address line");
    aggregate.setPharmacyId(42L);
    aggregate.addDeliveryLine(deliveryLine);
    aggregate.changeDeliveryLineAmount(10L, 20L);

    final Collection<DeliveryEvent> events = aggregate.getDeliveryEvents();

    assertThat(events)
        .isNotNull()
        .isNotEmpty();

    final DeliveryAggregate anotherAggregate = factory.newInstance();
    events.forEach(anotherAggregate::accept);

    assertThat(anotherAggregate)
        .extracting("addressLine", "pharmacyId")
        .contains("Some address line", 42L);
  }
}