package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.HasId;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import java.util.Collection;
import java.util.Optional;

public interface CrudService<T extends HasId<Long>> {
  CrudRepository<T, Long> getRepository();

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
