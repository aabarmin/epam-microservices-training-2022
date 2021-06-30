package com.epam.training.microservice.service.pharmacies.model;

import lombok.Data;

@Data
public class DrugModel {
    private Long id;
    private String name;
    private String description;
    private String available;
}
