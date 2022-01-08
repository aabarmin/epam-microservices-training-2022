package com.epam.training.microservices.service.axon.aggregate;

import com.epam.training.microservices.service.axon.command.ConfirmOrderCommand;
import com.epam.training.microservices.service.axon.event.OrderConfirmedEvent;
import java.time.LocalDateTime;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

/**
 * @author Aleksandr Barmin
 */
@Aggregate
public class DeliveryAggregate {
  @AggregateIdentifier
  private String orderId;
  private DeliveryState deliveryState;

  @CommandHandler
  public DeliveryAggregate(final ConfirmOrderCommand command) {
    AggregateLifecycle.apply(new OrderConfirmedEvent(
        command.getOrderId(),
        LocalDateTime.now()
    ));
  }

  @EventHandler
  public void on(final OrderConfirmedEvent event) {
    this.orderId = event.getOrderId();
    this.deliveryState = DeliveryState.CONFIRMED;
  }
}
