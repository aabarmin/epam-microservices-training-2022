package com.epam.training.microservices.monolithic.web.rest;

import com.epam.training.microservices.monolithic.service.DeliveryService;
import com.epam.training.microservices.monolithic.web.model.DeliveryModel;
import com.epam.training.microservices.monolithic.web.transformer.DeliveryModelTransformer;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
  @Autowired
  private DeliveryService deliveryService;

  @Autowired
  private DeliveryModelTransformer transformer;

  public Collection<DeliveryModel> findAll() {
    return deliveryService.findAll()
        .stream()
        .map(transformer::toModel)
        .collect(Collectors.toList());
  }
}
