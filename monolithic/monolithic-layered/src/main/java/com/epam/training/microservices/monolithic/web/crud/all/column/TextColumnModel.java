package com.epam.training.microservices.monolithic.web.crud.all.column;

import java.util.function.Function;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class TextColumnModel<T> implements ColumnModel<T> {
  private final String title;
  private final Function<T, String> valueSupplier;

  @Override
  public String getValue(T instance) {
    return valueSupplier.apply(instance);
  }

  @Override
  public String getType() {
    return "TEXT";
  }
}
