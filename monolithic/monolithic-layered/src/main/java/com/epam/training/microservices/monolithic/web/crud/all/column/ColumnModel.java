package com.epam.training.microservices.monolithic.web.crud.all.column;

public interface ColumnModel<T> {
  String getTitle();
  String getValue(T instance);
  String getType();
}
