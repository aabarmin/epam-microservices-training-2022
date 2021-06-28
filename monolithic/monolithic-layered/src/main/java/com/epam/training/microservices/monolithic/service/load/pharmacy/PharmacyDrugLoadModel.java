package com.epam.training.microservices.monolithic.service.load.pharmacy;

import lombok.Data;

@Data
public class PharmacyDrugLoadModel {
  private String drugName;
  private Long amount;
}
