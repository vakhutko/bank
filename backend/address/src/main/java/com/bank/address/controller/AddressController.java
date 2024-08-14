package com.bank.address.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class AddressController {
    private final AddressHandler addressHandler;

    @Bean
    RouterFunction<ServerResponse> getAccountRoutes() {
        return route()
                .GET("/address/{id}", addressHandler::getAddressById)
                .GET("/address", addressHandler::getAllAddresses)
                .POST("/address", addressHandler::createAddress)
                .PUT("/address", addressHandler::updateAddress)
                .DELETE("/address/{id}", addressHandler::deleteAddress)
                .build();
    }
}
