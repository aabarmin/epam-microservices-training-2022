package com.epam.training.microservices.services.state.machine.delivery.mq;

import com.epam.training.microservices.services.state.machine.delivery.model.OrderEvent;
import com.epam.training.microservices.services.state.machine.delivery.service.DeliveryService;
import java.util.function.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitListenersConfiguration {
  @Autowired
  private DeliveryService deliveryService;

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
