package com.epam.training.microservices.monolithic.service.load.pharmacy;

import com.epam.training.microservices.monolithic.model.delivery.DeliveryStatus;
import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;

@Data
public class PharmacyOrderLoadModel {
  private String address;
  private DeliveryStatus status;
  private List<PharmacyOrderLineLoadModel> content = Lists.newArrayList();
}
