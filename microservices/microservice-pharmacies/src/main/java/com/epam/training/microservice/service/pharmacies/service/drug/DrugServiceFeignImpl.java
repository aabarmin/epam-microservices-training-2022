package com.epam.training.microservice.service.pharmacies.service.drug;

import com.epam.training.microservice.service.pharmacies.model.DrugModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DrugServiceFeignImpl implements DrugService {
    @Autowired
    private DrugServiceFeignClient feignClient;

    @Override
    public Optional<Long> getDrugIdByName(String drugName) {
        return Optional.ofNullable(feignClient.findDrugByName(drugName))
                .map(EntityModel::getContent)
                .map(DrugModel::getId);
    }
}
