package com.epam.training.microservice.service.pharmacies.service.drug;

import com.epam.training.microservice.service.pharmacies.model.DrugModel;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DrugServiceFeignImpl implements DrugService {
    private final DrugServiceFeignClient feignClient;

    @Override
    public Optional<Long> getDrugIdByName(String drugName) {
        return Optional.ofNullable(feignClient.findDrugByName(drugName))
                .map(EntityModel::getContent)
                .map(DrugModel::getId);
    }
}
