package com.epam.training.microservices.service.axon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Aleksandr Barmin
 */
@SpringBootApplication
public class AxonSagaApplication {
  public static void main(String[] args) {
    SpringApplication.run(AxonSagaApplication.class, args);
  }
}
