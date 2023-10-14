package com.epam.training.microservices.monolithic.web.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.model.delivery.DeliveryLine;
import com.epam.training.microservices.monolithic.service.delivery.DeliveryService;
import com.epam.training.microservices.monolithic.service.drug.DrugService;
import com.epam.training.microservices.monolithic.service.pharmacy.PharmacyService;
import com.epam.training.microservices.monolithic.web.crud.SelectItem;
import java.util.Collection;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DeliveryTransformer {
  private final PharmacyService pharmacyService;
  private final DrugService drugService;
  private final DeliveryService deliveryService;

  @Transactional
  public DeliveryModel toModel(Long id) {
    final Delivery delivery = deliveryService.findOne(id)
        .orElseThrow(() -> new RuntimeException("No com.epam.training.service.delivery with id " + id));

    return DeliveryModel.builder()
        .id(delivery.getId())
        .addressLine(delivery.getAddressLine())
        .status(delivery.getStatus().name())
        .pharmacyId(delivery.getPharmacy().getId())
        .pharmacies(getPharmacies())
        .content(getContent(delivery))
        .build();
  }

  private Collection<SelectItem> getPharmacies() {
    return pharmacyService.findAll()
        .stream()
        .map(ph -> new SelectItem(ph.getId(), ph.getName()))
        .collect(Collectors.toList());
  }

  private Collection<DeliveryLineModel> getContent(Delivery delivery) {
    return delivery.getContent()
        .stream()
        .map(this::getDeliveryLineModel)
        .collect(Collectors.toList());
  }

  private DeliveryLineModel getDeliveryLineModel(DeliveryLine line) {
    return DeliveryLineModel.builder()
        .drugs(getDrugs())
        .drugId(line.getDrug().getId())
        .amount(line.getAmount())
        .build();
  }

  private Collection<SelectItem> getDrugs() {
    return drugService.findAll()
        .stream()
        .map(d -> new SelectItem(d.getId(), d.getName()))
        .collect(Collectors.toList());
  }
}
