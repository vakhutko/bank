package com.bank.user.controller;

import com.bank.user.entity.User;
import com.bank.user.service.UserService;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Data
@Component
public class UserHandler {
    private final UserService userService;

    public Mono<ServerResponse> getUser(ServerRequest request) {
        return ServerResponse.ok().body(userService.getUser(), User.class);
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        return ServerResponse.ok().body(userService.createUser(request.bodyToMono(User.class)), User.class);
    }
}
