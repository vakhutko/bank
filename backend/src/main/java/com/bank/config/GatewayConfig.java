package com.bank.config;

import com.bank.filters.CustomFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, CustomFilter customFilter) {
        return builder.routes()
                .route("account", r -> r.path("/accounts/**")
                        .filters(f -> f.filter(customFilter.apply(new CustomFilter.Config())))
                        .uri("http://localhost:8081"))
                .route("authentication", r -> r.path("/api/v1/**")
                        .filters(f -> f.filter(customFilter.apply(new CustomFilter.Config())))
                        .uri("http://localhost:8082"))
                .route("transaction", r -> r.path("/transactions/**")
                        .filters(f -> f.filter(customFilter.apply(new CustomFilter.Config())))
                        .uri("http://localhost:8083"))
                .build();
    }
}
