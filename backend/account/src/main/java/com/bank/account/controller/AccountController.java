package com.bank.account.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class AccountController {
    private final AccountHandler accountHandler;

    @Bean
    RouterFunction<ServerResponse> getAccountRoutes() {
        return route()
                .GET("/accounts/{number}", accountHandler::getAccount)
                .POST("/accounts", accountHandler::createAccount)
                .PUT("/accounts/{number}", accountHandler::updateAccount)
                .GET("/example/service", _ -> ServerResponse.ok().body(fromValue("Hello from the Example Microservice!")))
                .build();
    }
}
