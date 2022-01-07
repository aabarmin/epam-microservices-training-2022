package com.epam.training.microservices.monolithic.loader.pharmacy;

import lombok.Data;

@Data
public class PharmacyOrderLineLoadModel {
  private String drug;
  private Long amount;
}
