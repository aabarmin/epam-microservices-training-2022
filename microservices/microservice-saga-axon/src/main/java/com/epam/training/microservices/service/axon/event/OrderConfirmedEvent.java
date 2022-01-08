package com.epam.training.microservices.service.axon.event;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author Aleksandr Barmin
 */
@Data
public class OrderConfirmedEvent {
  private final String orderId;
  private final LocalDateTime confirmedDate;
}
