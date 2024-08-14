package com.bank.user.controller;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Data
@Controller
public class UserController {
    private final UserHandler userHandler;

    @Bean
    RouterFunction<ServerResponse> routerFunction() {
        return route()
                .GET("/users", userHandler::getUser)
                .POST("/users", userHandler::createUser)
                .build();
    }
}
