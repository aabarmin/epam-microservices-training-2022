package com.epam.training.microservices.services.state.machine.delivery.model;

public enum DeliveryState {
  /**
   * The order is confirmed by a user, need to start a com.epam.training.service.delivery.
   */
  CONFIRMED,
  /**
   * Not available, will not be delivered.
   */
  NOT_AVAILABLE,
  /**
   * Available, the com.epam.training.service.delivery has been started.
   */
  DELIVERY,
  /**
   * The order has been delivered.
   */
  DELIVERED;
}
