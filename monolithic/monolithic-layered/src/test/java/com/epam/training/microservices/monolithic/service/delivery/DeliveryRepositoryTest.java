package com.epam.training.microservices.monolithic.service.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.model.delivery.DeliveryStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class DeliveryRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

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
