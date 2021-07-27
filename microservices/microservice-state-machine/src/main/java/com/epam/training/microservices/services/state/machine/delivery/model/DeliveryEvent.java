package com.epam.training.microservices.services.state.machine.delivery.model;

public enum DeliveryEvent {
  /**
   * The user confirms the com.epam.training.service.delivery.
   */
  CONFIRM,
  /**
   * When drugs are not available.
   */
  REJECT,
  /**
   * When a com.epam.training.service.delivery is started.
   */
  START_DELIVERY,
  /**
   * When com.epam.training.service.delivery is done.
   */
  END_DELIVERY;
}
