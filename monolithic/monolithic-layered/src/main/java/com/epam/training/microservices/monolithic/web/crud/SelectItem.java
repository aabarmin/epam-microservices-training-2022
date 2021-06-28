package com.epam.training.microservices.monolithic.web.crud;

import lombok.Data;
import lombok.Value;

@Value
public class SelectItem {
  Long id;
  String value;
}
