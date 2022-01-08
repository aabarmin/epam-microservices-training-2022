package com.epam.training.microservices.services.state.machine.delivery.model;

import lombok.Data;

@Data
public class OrderEvent {
  private String orderId;
}
