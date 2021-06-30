package com.epam.training.microservice.service.pharmacies.service.load;

import lombok.Data;

@Data
public class PharmacyAvailableLoadModel {
    private String drugName;
    private Long amount;
}
