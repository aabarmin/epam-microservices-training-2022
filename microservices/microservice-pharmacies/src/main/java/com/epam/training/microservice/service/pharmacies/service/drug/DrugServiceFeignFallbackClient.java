package com.epam.training.microservice.service.pharmacies.service.drug;

import com.epam.training.microservice.service.pharmacies.model.DrugModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DrugServiceFeignFallbackClient implements DrugServiceFeignClient {
    @Override
    public EntityModel<DrugModel> findDrugByName(String name) {
        log.warn("This is the response from the fallback service");
        return EntityModel.of(new DrugModel());
    }
}
