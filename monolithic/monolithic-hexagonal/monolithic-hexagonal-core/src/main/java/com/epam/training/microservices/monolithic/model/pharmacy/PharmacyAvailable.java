package com.epam.training.microservices.monolithic.model.pharmacy;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import lombok.Data;

@Data
public class PharmacyAvailable {
  private Long id;

  private Pharmacy pharmacy;

  private Drug drug;

  private Long amount;
}
