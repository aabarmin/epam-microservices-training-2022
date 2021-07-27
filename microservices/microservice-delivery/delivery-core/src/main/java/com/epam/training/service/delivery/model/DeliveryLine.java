package com.epam.training.service.delivery.model;

import lombok.Data;

@Data
public class DeliveryLine {
  private Long id;
  private Long amount;
  private Long drugId;
}
