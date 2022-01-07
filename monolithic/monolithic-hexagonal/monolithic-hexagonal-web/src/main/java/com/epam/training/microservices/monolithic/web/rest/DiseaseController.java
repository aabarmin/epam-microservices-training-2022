package com.epam.training.microservices.monolithic.web.rest;

import com.epam.training.microservices.monolithic.service.DiseaseService;
import com.epam.training.microservices.monolithic.web.model.DiseaseModel;
import com.epam.training.microservices.monolithic.web.transformer.DiseaseModelTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diseases")
public class DiseaseController {
  private final DiseaseService diseaseService;
  private final DiseaseModelTransformer transformer;

  @GetMapping("/")
  public Collection<DiseaseModel> findAll() {
    return diseaseService.findAll()
        .stream()
        .map(transformer::toModel)
        .collect(Collectors.toList());
  }
}
