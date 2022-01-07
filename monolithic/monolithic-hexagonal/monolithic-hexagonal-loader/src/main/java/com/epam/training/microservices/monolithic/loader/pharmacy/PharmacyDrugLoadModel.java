package com.epam.training.microservices.monolithic.loader.pharmacy;

import lombok.Data;

@Data
public class PharmacyDrugLoadModel {
  private String drugName;
  private Long amount;
}
