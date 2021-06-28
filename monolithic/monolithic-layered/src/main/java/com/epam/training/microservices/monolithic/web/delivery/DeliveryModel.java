package com.epam.training.microservices.monolithic.web.delivery;

import com.epam.training.microservices.monolithic.web.crud.SelectItem;
import com.google.common.collect.Lists;
import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryModel {
  private Long id;
  private String addressLine;
  private String status;
  private Long pharmacyId;

  @Builder.Default
  private Collection<DeliveryLineModel> content = Lists.newArrayList();
  @Builder.Default
  private Collection<SelectItem> pharmacies = Lists.newArrayList();
}
