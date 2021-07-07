package com.epam.training.miservices.services.drugs.controller;

import com.epam.training.miservices.services.drugs.model.Drug;
import com.epam.training.miservices.services.drugs.repository.DrugRepository;
import java.util.Collection;
import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/info")
public class ApiV1Controller {
  private String serviceId;

  @PostConstruct
  public void init() {
    serviceId = UUID.randomUUID().toString();
  }

  @GetMapping
  public String getServiceId() {
    return serviceId;
  }
}
