package com.epam.training.microservices.services.state.machine.delivery.model;

public enum DeliveryEvent {
  /**
   * The user confirms the delivery.
   */
  CONFIRM,
  /**
   * When drugs are not available.
   */
  REJECT,
  /**
   * When a delivery is started.
   */
  START_DELIVERY,
  /**
   * When delivery is done.
   */
  END_DELIVERY;
}
