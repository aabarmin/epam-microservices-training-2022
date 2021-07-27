package com.epam.training.service.delivery.model;

import com.epam.training.service.delivery.event.AddDeliveryLineEvent;
import com.epam.training.service.delivery.event.ChangeDeliveryLineAmountEvent;
import com.epam.training.service.delivery.event.ChangeFieldEvent;
import com.epam.training.service.delivery.event.DeliveryEvent;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.Setter;

public class DeliveryAggregate implements Consumer<DeliveryEvent> {
  private Long id;
  private String addressLine;
  private DeliveryStatus status;
  private Long pharmacyId;
  private Collection<DeliveryLine> content = Lists.newArrayList();

  @Setter(AccessLevel.NONE)
  private Collection<DeliveryEvent> deliveryEvents = Lists.newArrayList();

  @Override
  public void accept(DeliveryEvent event) {
    event.process(this);
    deliveryEvents.add(event);
  }

  private void addEvent(final @NonNull DeliveryEvent event) {
    this.deliveryEvents.add(event);
  }

  public void addDeliveryLine(DeliveryLine line) {
    this.content.add(line);
    addEvent(new AddDeliveryLineEvent(line));
  }

  public void changeDeliveryLineAmount(Long lineId, Long amount) {
    final DeliveryLine deliveryLine = content.stream()
        .filter(line -> line.getId() == lineId)
        .findFirst()
        .get();

    deliveryLine.setAmount(amount);

    addEvent(new ChangeDeliveryLineAmountEvent(lineId, amount));
  }

  public void setId(Long id) {
    this.id = id;
    addEvent(new ChangeFieldEvent("id", id));
  }

  public void setAddressLine(String addressLine) {
    this.addressLine = addressLine;
    addEvent(new ChangeFieldEvent("addressLine", addressLine));
  }

  public void setStatus(DeliveryStatus status) {
    this.status = status;
    addEvent(new ChangeFieldEvent("status", status));
  }

  public void setPharmacyId(Long pharmacyId) {
    this.pharmacyId = pharmacyId;
    addEvent(new ChangeFieldEvent("pharmacyId", pharmacyId));
  }

  public Collection<DeliveryEvent> getDeliveryEvents() {
    return Collections.unmodifiableCollection(deliveryEvents);
  }

  public Long getId() {
    return id;
  }

  public String getAddressLine() {
    return addressLine;
  }

  public DeliveryStatus getStatus() {
    return status;
  }

  public Long getPharmacyId() {
    return pharmacyId;
  }

  public Collection<DeliveryLine> getContent() {
    return content;
  }
}
