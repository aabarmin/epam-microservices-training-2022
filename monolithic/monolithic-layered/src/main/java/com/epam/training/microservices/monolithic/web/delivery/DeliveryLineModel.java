package com.epam.training.microservices.monolithic.web.delivery;

import com.epam.training.microservices.monolithic.web.crud.SelectItem;
import com.google.common.collect.Lists;
import java.util.Collection;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeliveryLineModel {
  private Long id;
  private Long drugId;
  private Long amount;

  @Builder.Default
  private Collection<SelectItem> drugs = Lists.newArrayList();
}
