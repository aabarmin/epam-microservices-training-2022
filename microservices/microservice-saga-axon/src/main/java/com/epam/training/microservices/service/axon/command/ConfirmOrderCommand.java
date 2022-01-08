package com.epam.training.microservices.service.axon.command;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Aleksandr Barmin
 */
@Data
@RequiredArgsConstructor
public class ConfirmOrderCommand {
  private final String orderId;
}
