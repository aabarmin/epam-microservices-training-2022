package com.epam.training.microservices.monolithic.model.pharmacy;

import com.epam.training.microservices.monolithic.model.HasId;
import com.google.common.collect.Sets;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "available")
public class Pharmacy implements HasId<Long> {
  private Long id;

  private String name;
  private String address;

  private Set<PharmacyAvailable> available = Sets.newHashSet();
}
