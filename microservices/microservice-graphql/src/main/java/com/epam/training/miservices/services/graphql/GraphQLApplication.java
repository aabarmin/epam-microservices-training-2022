package com.epam.training.miservices.services.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GraphQLApplication {
  public static void main(String[] args) {
    SpringApplication.run(GraphQLApplication.class, args);
  }
}
