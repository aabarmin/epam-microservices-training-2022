package com.epam.training.microservices.monolithic.service.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeliveryServiceTest {

    @Mock
    private DeliveryRepository deliveryRepository;

    @InjectMocks
    private DeliveryService deliveryService;

    @DisplayName("Test getRepository method")
    @Test
    void shouldGetRepository() {
        JpaRepository<Delivery, Long> expectedRepo = deliveryRepository;
        JpaRepository<Delivery, Long> resultRepo = deliveryService.getRepository();

        assertEquals(expectedRepo, resultRepo);
    }

    @DisplayName("Test save method")
    @Test
    void shouldSaveDelivery() {
        Delivery delivery = new Delivery();
        when(deliveryRepository.save(delivery)).thenReturn(delivery);

        Delivery savedDelivery = deliveryService.save(delivery);

        verify(deliveryRepository, times(1)).save(eq(delivery));
        assertEquals(delivery, savedDelivery);
    }

    @DisplayName("Test findOne method")
    @Test
    void shouldFindOneDeliveryById() {
        Delivery delivery = new Delivery();
        delivery.setId(1L);
        when(deliveryRepository.findById(1L)).thenReturn(Optional.of(delivery));

        Optional<Delivery> foundDelivery = deliveryService.findOne(1L);

        assertTrue(foundDelivery.isPresent());
        assertEquals(delivery, foundDelivery.get());
    }

    @DisplayName("Test findAll method")
    @Test
    void shouldFindAllDeliveries() {
        Delivery delivery1 = new Delivery();
        Delivery delivery2 = new Delivery();

        when(deliveryRepository.findAll()).thenReturn(Arrays.asList(delivery1, delivery2));

        Collection<Delivery> deliveries = deliveryService.findAll();

        assertNotNull(deliveries);
        assertEquals(2, deliveries.size());
        assertTrue(deliveries.contains(delivery1));
        assertTrue(deliveries.contains(delivery2));
    }
}
