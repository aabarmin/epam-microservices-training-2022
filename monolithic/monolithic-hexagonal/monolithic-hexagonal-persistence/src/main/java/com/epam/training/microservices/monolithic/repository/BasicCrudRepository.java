package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.HasId;
import com.epam.training.microservices.monolithic.transformer.Transformer;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BasicCrudRepository<MODEL extends HasId<KEY>, ENTITY, KEY>
    implements CrudRepository<MODEL, KEY> {

  protected abstract Transformer<MODEL, ENTITY> getTransformer();
  protected abstract JpaRepository<ENTITY, KEY> getJpaRepository();

  @Override
  public Collection<MODEL> findAll() {
    return getJpaRepository().findAll()
        .stream()
        .map(entity -> getTransformer().toModel(entity))
        .collect(Collectors.toList());
  }

  @Override
  public Optional<MODEL> findById(KEY id) {
    return getJpaRepository().findById(id)
        .map(entity -> getTransformer().toModel(entity));
  }

  @Override
  public MODEL save(MODEL instance) {
    final ENTITY newOrExistingEntity = Optional.ofNullable(instance.getId())
        .flatMap(id -> getJpaRepository().findById(id))
        .orElseGet(() -> getTransformer().newEntity());

    getTransformer().toEntity(newOrExistingEntity, instance);
    final ENTITY savedEntity = getJpaRepository().save(newOrExistingEntity);

    return getTransformer().toModel(savedEntity);
  }
}
