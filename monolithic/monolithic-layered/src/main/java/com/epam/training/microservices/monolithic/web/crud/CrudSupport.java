package com.epam.training.microservices.monolithic.web.crud;

import com.epam.training.microservices.monolithic.service.CrudService;

public interface CrudSupport<T> {
  CrudService<T> getService();
}
