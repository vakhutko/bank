package com.bank.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
    public static final List<String> openApiEndpoints = List.of(
            "/api/v1/auth/login",
            "/api/v1/auth/register"
//            "/eureka"
    );

    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Pre-processing
            if (openApiEndpoints.stream().noneMatch(uri -> exchange.getRequest().getURI().getPath().contains(uri))) {
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }
            }

            // Post-processing
            return chain.filter(exchange).then(Mono.fromRunnable(() -> exchange
                    .getResponse().getHeaders().add("X-Response-Default-Foo", "Default-Bar")));
        };
    }

    public static class Config {
        // Put the configuration properties for your filter here
    }
}
