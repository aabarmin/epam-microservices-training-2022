package com.epam.training.microservices.monolithic.service.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.model.delivery.DeliveryStatus;
import com.epam.training.microservices.monolithic.service.BaseDataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeliveryRepositoryTest extends BaseDataJpaTest {

    @Autowired
    private DeliveryRepository repository;

    @Test
    public void shouldSaveAndRetrieveDelivery() {
        // Arrange
        Delivery delivery = new Delivery();
        delivery.setAddressLine("123 Test St.");
        delivery.setStatus(DeliveryStatus.IN_QUEUE);

        entityManager.persistAndFlush(delivery);

        // Act
        Delivery found = repository.findById(delivery.getId()).orElse(null);

        // Assert
        assertNotNull(found);
        assertEquals("123 Test St.", found.getAddressLine());
        assertEquals(DeliveryStatus.IN_QUEUE, found.getStatus());
    }
}
