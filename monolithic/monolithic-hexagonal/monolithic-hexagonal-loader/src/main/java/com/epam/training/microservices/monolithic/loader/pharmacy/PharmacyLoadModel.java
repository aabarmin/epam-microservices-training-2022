package com.epam.training.microservices.monolithic.loader.pharmacy;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class PharmacyLoadModel {
  private String name;
  private String address;
  private List<PharmacyDrugLoadModel> drugs = Lists.newArrayList();
  private List<PharmacyOrderLoadModel> orders = Lists.newArrayList();
}
