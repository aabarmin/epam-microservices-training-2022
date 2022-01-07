package com.epam.training.microservice.service.recipes.service;

import com.epam.training.microservice.service.recipes.model.DrugModel;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@Component
@Deprecated
public class DrugServiceClient {
    @Autowired
    private EurekaClient eurekaClient;

    private String getDrugServiceUrl() {
        return eurekaClient.getApplication("drug-service")
            .getInstances()
            .stream()
            .findFirst()
            .map(info -> "http://" + info.getHostName() + ":" + info.getPort())
            .orElseThrow();
    }

    public Optional<Long> getDrugIdByName(String drugName) {
        final Traverson traverson = new Traverson(URI.create(getDrugServiceUrl()),
            MediaTypes.HAL_JSON);

        final DrugModel record = traverson
                .follow("drugs", "search", "findDrugByName")
                .withTemplateParameters(Map.of("name", drugName))
                .toObject(DrugModel.class);

        return Optional.ofNullable(record)
                .map(DrugModel::getId);
    }
}
