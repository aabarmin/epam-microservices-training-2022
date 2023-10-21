package com.epam.training.microservice.service.recipes.service.drugs;

import com.epam.training.microservice.service.recipes.model.DrugModel;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.mockito.Mockito.mock;

@Component
@Profile("test")
public class DrugServiceMock implements DrugService {

    @Override
    public Optional<DrugModel> findById(Long id) {
        final DrugModel record = mock();
        return Optional.of(record);
    }

    @Override
    public Optional<Long> getDrugIdByName(String drugName) {
        return Optional.of((long) drugName.hashCode());
    }
}
