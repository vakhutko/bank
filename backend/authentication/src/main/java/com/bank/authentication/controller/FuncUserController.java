package com.bank.authentication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class FuncUserController {
    private final UserHandler userHandler;
    private final PersonHandler personHandler;

    @Bean
    RouterFunction<ServerResponse> getUserRoutes() {
        return route()
                .GET("/api/v1/auth/info", accept(MediaType.APPLICATION_JSON), userHandler::info)
                .POST("/api/v1/auth/login", userHandler::login)
                .POST("/api/v1/auth/logout", userHandler::logout)
                .POST("/api/v1/auth/register", userHandler::register)
                .GET("/api/v1/users", accept(MediaType.APPLICATION_JSON), userHandler::getUsers)
                .PUT("/api/v1/users", userHandler::updateUser)
                .DELETE("/api/v1/users/{id}", userHandler::deleteUser)
                .POST("/api/v1/persons", personHandler::createPerson)
                .build();
    }
}
