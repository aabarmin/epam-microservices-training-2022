package com.epam.training.microservices.monolithic.loader.pharmacy;

import com.epam.training.microservices.monolithic.model.delivery.DeliveryStatus;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class PharmacyOrderLoadModel {
  private String address;
  private DeliveryStatus status;
  private List<PharmacyOrderLineLoadModel> content = Lists.newArrayList();
}
