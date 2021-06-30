package com.epam.training.microservice.service.pharmacies.repository;

import com.epam.training.microservice.service.pharmacies.model.DrugModel;
import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.hateoas.server.core.TypeReferences;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class DrugServiceClient {
    public Optional<Long> getDrugIdByName(String drugName) {
        final Traverson traverson = new Traverson(URI.create("http://localhost:8082/"), MediaTypes.HAL_JSON);

        final DrugModel record = traverson
                .follow("drugs", "search", "findDrugByName")
                .withTemplateParameters(Map.of("name", drugName))
                .toObject(DrugModel.class);

        return Optional.ofNullable(record)
                .map(DrugModel::getId);
    }
}
