package com.epam.training.miservices.services.graphql.web;

import com.epam.training.miservices.services.graphql.service.DrugModel;
import com.epam.training.miservices.services.graphql.service.DrugServiceFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
@SchemaMapping(typeName = "Drug")
@RequiredArgsConstructor
public class DrugController {
    private final DrugServiceFeignClient feignClient;

    @QueryMapping(name = "allDrugs")
    public Collection<DrugModel> findAll() {
        return feignClient.findAll()
                .getContent();
    }
}
