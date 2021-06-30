package com.epam.training.microservice.service.pharmacies.service.load;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Collection;

@Data
public class PharmacyLoadModel {
    private String name;
    private String address;
    private Collection<PharmacyAvailableLoadModel> drugs = Lists.newArrayList();
}
