package com.epam.training.miservices.services.graphql.web;

import com.epam.training.miservices.services.graphql.service.DrugModel;
import com.epam.training.miservices.services.graphql.service.DrugServiceFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.hateoas.CollectionModel;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@GraphQlTest(DrugController.class)
class DrugControllerTest {
    @Autowired
    GraphQlTester tester;

    @MockBean
    DrugServiceFeignClient feignClient;

    @Test
    void check_contextStarts() {
        assertThat(tester).isNotNull();
    }

    @Test
    void findAll_returnDrugs() {
        when(feignClient.findAll()).thenReturn(CollectionModel.of(List.of(
                new DrugModel()
        )));

        tester.documentName("allDrugs")
                .execute()
                .path("data.allDrugs")
                .entityList(DrugModel.class)
                .hasSizeGreaterThan(0);
    }
}