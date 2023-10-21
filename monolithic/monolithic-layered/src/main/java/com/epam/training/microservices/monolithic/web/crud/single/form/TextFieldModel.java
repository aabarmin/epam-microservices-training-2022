package com.epam.training.microservices.monolithic.web.crud.single.form;

import lombok.Data;

@Data
public class TextFieldModel<T> implements FieldModel<T> {
  private final String title;
  private final String field;

  public TextFieldModel(String title, String field) {
    this.title = title;
    this.field = field;
  }

  @Override
  public String getType() {
    return "TEXT";
  }
}
