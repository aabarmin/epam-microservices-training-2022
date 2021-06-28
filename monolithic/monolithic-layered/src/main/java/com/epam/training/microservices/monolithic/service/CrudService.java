package com.epam.training.microservices.monolithic.service;

import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudService<T> {
  JpaRepository<T, Long> getRepository();

  default T save(T object) {
    return getRepository().save(object);
  }

  default Optional<T> findOne(Long id) {
    return getRepository().findById(id);
  }

  default Collection<T> findAll() {
    return getRepository().findAll();
  }
}
