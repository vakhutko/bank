package com.bank.card.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@Data
@Configuration
public class CardController {
    private final CardHandler cardHandler;

    @Bean
    RouterFunction<ServerResponse> getCardRoutes() {
        return route()
                .GET("/cards/{cardId}", cardHandler::getCard)
                .POST("/cards", cardHandler::createCard)
                .PUT("/cards", cardHandler::updateCard)
                .DELETE("/cards/{cardId}", cardHandler::deleteCard)
                .build();
    }
}
