package com.epam.training.microservice.service.recipes.service.drugs;

import com.epam.training.microservice.service.recipes.model.DrugModel;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Hop;
import org.springframework.hateoas.client.Traverson;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("eureka-client")
public class DrugServiceWithEurekaClient implements DrugService {
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

    @Override
    public Optional<DrugModel> findById(Long id) {
        final Traverson traverson = new Traverson(URI.create(getDrugServiceUrl()),
            MediaTypes.HAL_JSON);

        final DrugModel record = traverson.follow("drugs", "search", "findDrugById")
            .withTemplateParameters(Map.of("id", id))
            .toObject(DrugModel.class);

        return Optional.ofNullable(record);
    }

    @Override
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
