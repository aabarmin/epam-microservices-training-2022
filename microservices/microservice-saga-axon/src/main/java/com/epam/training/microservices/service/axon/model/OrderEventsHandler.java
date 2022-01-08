package com.epam.training.microservices.service.axon.model;

import com.epam.training.microservices.service.axon.event.OrderConfirmedEvent;
import com.epam.training.microservices.service.axon.query.FindAllOrdersQuery;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Barmin
 */
@Component
public class OrderEventsHandler {
  private final Map<String, Order> storage = new HashMap<>();

  @EventHandler
  public void on(final OrderConfirmedEvent event) {
    storage.putIfAbsent(event.getOrderId(), new Order(event.getOrderId()));
  }

  @QueryHandler
  public Collection<Order> handler(final FindAllOrdersQuery query) {
    return List.copyOf(storage.values());
  }
}
