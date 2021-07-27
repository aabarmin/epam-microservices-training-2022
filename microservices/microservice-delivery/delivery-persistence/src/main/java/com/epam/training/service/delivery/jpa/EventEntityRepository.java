package com.epam.training.service.delivery.jpa;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventEntityRepository extends JpaRepository<EventEntity, Long> {
  Collection<EventEntity> findAllByEntityId(Long entityId);
}
