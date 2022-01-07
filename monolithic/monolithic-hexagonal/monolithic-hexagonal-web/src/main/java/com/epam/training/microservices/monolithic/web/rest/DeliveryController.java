package com.epam.training.microservices.monolithic.web.rest;

import com.epam.training.microservices.monolithic.service.DeliveryService;
import com.epam.training.microservices.monolithic.web.model.DeliveryModel;
import com.epam.training.microservices.monolithic.web.transformer.DeliveryModelTransformer;
import java.util.Collection;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController {
  private final DeliveryService deliveryService;
  private final DeliveryModelTransformer transformer;

  @GetMapping("/")
  public Collection<DeliveryModel> findAll() {
    return deliveryService.findAll()
        .stream()
        .map(transformer::toModel)
        .collect(Collectors.toList());
  }
}
