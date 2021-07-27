package com.epam.training.service.delivery.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;
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
