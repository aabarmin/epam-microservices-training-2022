package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.HasId;
import java.util.Collection;
import java.util.Optional;

public interface CrudRepository<MODEL extends HasId, KEY> {
  MODEL save(MODEL instance);

  Optional<MODEL> findById(KEY id);

  Collection<MODEL> findAll();
}
