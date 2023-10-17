package com.epam.training.microservices.monolithic;


import static org.assertj.core.api.Assertions.assertThat;

import com.epam.training.microservices.monolithic.web.DrugController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MonolithicApplicationTest {

    @Autowired
    private DrugController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
