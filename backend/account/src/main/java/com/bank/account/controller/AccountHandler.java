package com.bank.account.controller;

import com.bank.account.mapper.AccountMapper;
import com.bank.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@RequiredArgsConstructor
@Component
public class AccountHandler {
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public Mono<ServerResponse> createAccount(ServerRequest request) {
        return accountService.createAccount()
                .map(accountMapper::fromAccount)
                .flatMap(accountDto -> ok().body(fromValue(accountDto)));
    }

    public Mono<ServerResponse> getAccount(ServerRequest request) {
        return accountService.getAccountByNumber(request.pathVariable("number"))
                .map(accountMapper::fromAccount)
                .flatMap(accountDto -> ok().body(fromValue(accountDto)));
    }

    public Mono<ServerResponse> updateAccount(ServerRequest request) {
        return Mono.just(request)
                .log()
                .flatMap(r -> accountService.updateAccount(r.pathVariable("number"), r.queryParam("amount").orElseThrow()))
                .log()
                .map(accountMapper::fromAccount)
                .log()
                .flatMap(account -> ok().body(fromValue(account)));
    }
}
