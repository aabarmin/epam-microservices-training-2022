package com.epam.training.microservices.monolithic.web.crud.single.form;

import java.util.function.Function;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HiddenFieldModel<T> implements FieldModel<T> {
  private final String title;
  private final String field;

  @Override
  public String getType() {
    return "HIDDEN";
  }
}
