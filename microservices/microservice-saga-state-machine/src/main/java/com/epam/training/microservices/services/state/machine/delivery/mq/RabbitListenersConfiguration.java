package com.epam.training.microservices.services.state.machine.delivery.mq;

import com.epam.training.microservices.services.state.machine.delivery.model.OrderEvent;
import com.epam.training.microservices.services.state.machine.delivery.service.DeliveryService;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitListenersConfiguration {
  private final DeliveryService deliveryService;

  @Bean
  public Consumer<OrderEvent> confirmOrder() {
    return event -> deliveryService.confirmOrder(event.getOrderId());
  }

  @Bean
  public Consumer<OrderEvent> rejectOrder() {
    return event -> deliveryService.rejectOrder(event.getOrderId());
  }

  @Bean
  public Consumer<OrderEvent> startDelivery() {
    return event -> deliveryService.startDelivery(event.getOrderId());
  }

  @Bean
  public Consumer<OrderEvent> completeDelivery() {
    return event -> deliveryService.completeDelivery(event.getOrderId());
  }
}
