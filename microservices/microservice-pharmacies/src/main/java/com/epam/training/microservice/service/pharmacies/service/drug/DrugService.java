package com.epam.training.microservice.service.pharmacies.service.drug;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface DrugService {
    Optional<Long> getDrugIdByName(String drugName);
}
