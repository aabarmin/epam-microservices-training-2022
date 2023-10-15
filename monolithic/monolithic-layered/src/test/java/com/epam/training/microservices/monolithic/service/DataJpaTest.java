package com.epam.training.microservices.monolithic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
public abstract class DataJpaTest {

    @Autowired
    protected TestEntityManager entityManager;

}
