package com.bank.transaction.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class TransactionController {
    private final TransactionHandler transactionHandler;

    @Bean
    RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route()
                .GET("/transactions", transactionHandler::getAllTransactions)
                .POST("/transactions", transactionHandler::createTransaction)
                .GET("/transactions/{id}", transactionHandler::getTransactionById)
                .PUT("/transactions/{id}", transactionHandler::updateTransaction)
                .DELETE("/transactions/{id}", transactionHandler::deleteTransaction)
                .build();
    }
}
