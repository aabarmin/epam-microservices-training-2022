package com.epam.training.microservices.monolithic.web.crud.single.form;

public class TextFieldModel<T> extends HiddenFieldModel<T> {
  public TextFieldModel(String title, String field) {
    super(title, field);
  }

  @Override
  public String getType() {
    return "TEXT";
  }
}
