package com.epam.training.microservices.monolithic.web.crud.all.column;

import java.util.function.Function;

public class LinkColumnModel<T> extends TextColumnModel<T> {
  private final Function<T, String> linkSupplier;

  public LinkColumnModel(String title, Function<T, String> valueSupplier,
                         Function<T, String> linkSupplier) {
    super(title, valueSupplier);
    this.linkSupplier = linkSupplier;
  }

  public String getLink(T instance) {
    return linkSupplier.apply(instance);
  }

  @Override
  public String getType() {
    return "LINK";
  }
}
