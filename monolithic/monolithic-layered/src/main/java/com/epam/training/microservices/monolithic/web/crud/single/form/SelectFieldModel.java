package com.epam.training.microservices.monolithic.web.crud.single.form;


import lombok.Getter;

import java.util.Collection;

@Getter
public class SelectFieldModel<T> extends TextFieldModel<T>  {

  private final Long value;
  private final Collection content;

  public SelectFieldModel(String title, String field, Long value, Collection content) {
    super(title, field);
    this.value = value;
    this.content = content;
  }

  @Override
  public String getType() {
    return "SELECT";
  }
}
