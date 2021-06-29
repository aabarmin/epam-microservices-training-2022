package com.epam.training.microservices.monolithic.web.model;

import com.epam.training.microservices.monolithic.model.delivery.DeliveryStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryModel {
  private Long id;
  private String addressLine;
  private DeliveryStatus status;
  private String pharmacyName;
}
