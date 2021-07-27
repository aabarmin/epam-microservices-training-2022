package com.epam.training.service.delivery.event;

import com.epam.training.service.delivery.model.DeliveryAggregate;
import com.epam.training.service.delivery.model.DeliveryLine;
import lombok.Data;

@Data
public class AddDeliveryLineEvent implements DeliveryEvent {
  private DeliveryLine line;
  private Long id;

  public AddDeliveryLineEvent(DeliveryLine line) {
    this.line = line;
  }

  @Override
  public void process(DeliveryAggregate aggregate) {
    aggregate.addDeliveryLine(line);
  }
}
