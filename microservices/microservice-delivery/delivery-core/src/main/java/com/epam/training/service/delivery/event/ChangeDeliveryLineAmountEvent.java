package com.epam.training.service.delivery.event;

import com.epam.training.service.delivery.model.DeliveryAggregate;
import com.epam.training.service.delivery.model.DeliveryLine;
import lombok.Data;

@Data
public class ChangeDeliveryLineAmountEvent implements DeliveryEvent {
  private Long id;

  private Long lineId;
  private Long amount;

  public ChangeDeliveryLineAmountEvent(Long lineId, Long amount) {
    this.lineId = lineId;
    this.amount = amount;
  }

  @Override
  public void process(DeliveryAggregate aggregate) {
    final DeliveryLine deliveryLine = aggregate.getContent()
        .stream()
        .filter(line -> line.getId() == lineId)
        .findFirst()
        .get();

    deliveryLine.setAmount(this.amount);
  }
}
