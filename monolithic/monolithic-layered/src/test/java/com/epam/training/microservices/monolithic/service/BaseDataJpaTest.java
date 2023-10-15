package com.epam.training.microservices.monolithic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public abstract class BaseDataJpaTest {

    @Autowired
    protected TestEntityManager entityManager;

}
