package com.epam.training.service.delivery.event;

import com.epam.training.service.delivery.model.DeliveryAggregate;
import java.lang.reflect.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeFieldEvent implements DeliveryEvent {
  private String field;
  private Object value;
  private Long id;

  public ChangeFieldEvent(String field, Object value) {
    this.field = field;
    this.value = value;
  }

  @Override
  @SneakyThrows
  public void process(DeliveryAggregate aggregate) {
    final Field declaredField = aggregate.getClass().getDeclaredField(field);
    declaredField.setAccessible(true);
    declaredField.set(aggregate, value);
  }
}
