package com.epam.training.microservices.monolithic.web.crud;

import com.epam.training.microservices.monolithic.service.CrudService;
import org.springframework.core.GenericTypeResolver;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

public interface CrudSupport<T> {
  CrudService<T> getService();

  default String getResourceName() {
    Class<T> tClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), CrudSupport.class);
    return tClass.getSimpleName();
  }
}
