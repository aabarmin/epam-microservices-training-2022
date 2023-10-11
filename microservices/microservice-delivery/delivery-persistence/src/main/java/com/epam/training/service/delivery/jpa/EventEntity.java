package com.epam.training.service.delivery.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "delivery_events")
public class EventEntity {
  @Id
  @Column(name = "EVENT_ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "EVENT_TYPE")
  private String eventType;

  @Size(max = Integer.MAX_VALUE)
  @Column(name = "EVENT_CONTENT")
  private String eventContent;

  @Column(name = "EVENT_ENTITY_ID")
  private Long entityId;

  @Version
  private Long version;
}
