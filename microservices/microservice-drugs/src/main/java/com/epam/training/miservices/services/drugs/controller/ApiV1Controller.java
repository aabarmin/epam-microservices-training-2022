package com.epam.training.miservices.services.drugs.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/info")
public class ApiV1Controller {
  private String serviceId;

  /**
   * /orders <- POST
   * /orders/1 <- GET
   * /orders/1/cancel <- GET
   * /orders/1/items <- POST/PUT/PATCH
   * /orders/1/items/1/cancel <- GET
   *
   * /API <- POST
   *
   * /orders <- ?projection=id,title,name,description
   * /orders/1/items <- ?projection=order.id,item.title
   */

  @PostConstruct
  public void init() {
    serviceId = UUID.randomUUID().toString();
  }

  @GetMapping
  public String getServiceId() {
    return serviceId;
  }
}
