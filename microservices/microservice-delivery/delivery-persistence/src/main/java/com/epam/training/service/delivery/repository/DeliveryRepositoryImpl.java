package com.epam.training.service.delivery.repository;

import com.epam.training.service.delivery.jpa.EventEntity;
import com.epam.training.service.delivery.jpa.EventEntityRepository;
import com.epam.training.service.delivery.json.EventTransformer;
import com.epam.training.service.delivery.model.DeliveryAggregate;
import com.epam.training.service.delivery.service.DeliveryAggregateFactory;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements DeliveryRepository {
  private final EventEntityRepository repository;

  private final DeliveryAggregateFactory factory;

  private final EventTransformer eventTransformer;

  @Override
  public Optional<DeliveryAggregate> findOne(Long id) {
    final Collection<EventEntity> events = repository.findAllByEntityId(id);
    if (events.isEmpty()) {
      return Optional.empty();
    }

    final DeliveryAggregate aggregate = factory.newInstance();

    events.stream()
        .map(eventTransformer::toEvent)
        .forEach(aggregate::accept);

    return Optional.of(aggregate);
  }

  @Override
  public DeliveryAggregate save(DeliveryAggregate aggregate) {
    final List<EventEntity> events = aggregate.getDeliveryEvents()
        .stream()
        .map(eventTransformer::toEntity)
        .collect(Collectors.toList());

    repository.saveAll(events);

    return aggregate;
  }
}
