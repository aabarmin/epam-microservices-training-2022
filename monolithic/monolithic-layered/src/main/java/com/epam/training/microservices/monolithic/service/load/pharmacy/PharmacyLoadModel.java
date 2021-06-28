package com.epam.training.microservices.monolithic.service.load.pharmacy;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;

@Data
public class PharmacyLoadModel {
  private String name;
  private String address;
  private List<PharmacyDrugLoadModel> drugs = Lists.newArrayList();
  private List<PharmacyOrderLoadModel> orders = Lists.newArrayList();
}
