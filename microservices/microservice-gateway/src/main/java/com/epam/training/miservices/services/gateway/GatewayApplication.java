package com.epam.training.miservices.services.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
        .route(
            "ya-route",
            r -> r.path("/ya").uri("https://ya.ru/")
        )
        .route(
            "drugs-route",
            r -> r.path("/drugs-store")
                .filters(f -> f
                    .stripPrefix(1)
                    .prefixPath("/drugs")
                    .addRequestHeader("Content-Type", "application/prs.hal-forms+json"))
                .uri("http://localhost:8083")
        )
        .route(
            "eureka-route",
            r -> r.path("/eureka")
                .filters(f -> f.stripPrefix(1))
                .uri("http://localhost:8081/")
        )
        .build();
  }
}
