package com.epam.training.service.delivery.json;

import com.epam.training.service.delivery.event.DeliveryEvent;
import com.epam.training.service.delivery.jpa.EventEntity;
import com.epam.training.service.delivery.jpa.EventEntityRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Optional;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventTransformer {
  private final EventEntityRepository repository;

  private Gson gson;

  @PostConstruct
  public void init() {
    gson = new GsonBuilder().create();
  }

  @SneakyThrows
  public DeliveryEvent toEvent(EventEntity entity) {
    final String eventType = entity.getEventType();
    final Class<? extends DeliveryEvent> eventClass = (Class<? extends DeliveryEvent>) Class.forName(eventType);

    final DeliveryEvent event = gson.fromJson(entity.getEventContent(), eventClass);
    event.setId(entity.getId());
    return event;
  }

  public EventEntity toEntity(final DeliveryEvent event) {
    final EventEntity entity = Optional.ofNullable(event.getId())
        .flatMap(repository::findById)
        .orElseGet(() -> new EventEntity());

    entity.setEventType(event.getClass().getName());
    entity.setEventContent(gson.toJson(event));
    entity.setId(entity.getId());

    return entity;
  }
}
