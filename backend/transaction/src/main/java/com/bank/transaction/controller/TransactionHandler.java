package com.bank.transaction.controller;

import com.bank.transaction.dto.TransactionDto;
import com.bank.transaction.entity.Account;
import com.bank.transaction.mapper.TransactionMapper;
import com.bank.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@RequiredArgsConstructor
@Component
public class TransactionHandler {
    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    public Mono<ServerResponse> getAllTransactions(ServerRequest request) {
        return ok().body(fromValue(transactionService.findAll().map(transactionMapper::fromTransaction)));
    }

    public Mono<ServerResponse> createTransaction(ServerRequest request) {
        return request.bodyToMono(TransactionDto.class)
                .map(transactionMapper::toTransaction)
                .map(transaction -> transaction.toBuilder().createdAt(LocalDateTime.now()).build())
                .flatMap(transactionService::save)
                .flatMap(transaction -> {
                            if (transaction.getPayeeAccount() != null) {
                                return WebClient
                                        .create("http://localhost:8081/")
                                        .method(PUT)
                                        .uri(builder -> builder.path("accounts/" + transaction.getPayerAccount())
                                                .queryParam("amount", (-transaction.getAmount())).build())
                                        .retrieve()
                                        .toEntity(Account.class)
                                        .then(WebClient
                                                .create("http://localhost:8081/")
                                                .method(PUT)
                                                .uri(builder -> builder.path("accounts/" + transaction.getPayeeAccount())
                                                        .queryParam("amount", transaction.getAmount()).build())
                                                .retrieve()
                                                .toEntity(Account.class))
                                        .then(Mono.just(transaction));
//                                return accountRepository.findByNumber(transaction.getPayerAccount())
//                                        .doOnNext(account -> account.setBalance(account.getBalance() - transaction.getAmount()))
//                                        .flatMap(accountRepository::save)
//                                        .then(accountRepository.findByNumber(transaction.getPayeeAccount()))
//                                        .doOnNext(account -> account.setBalance(account.getBalance() + transaction.getAmount()))
//                                        .flatMap(accountRepository::save)
//                                        .then(Mono.just(transaction));
                            } else {
                                return WebClient
                                        .create("http://localhost:8081/")
                                        .method(PUT)
                                        .uri(builder -> builder.path("accounts/" + transaction.getPayerAccount())
                                                .queryParam("amount", transaction.getAmount()).build())
                                        .retrieve()
                                        .toEntity(Account.class)
                                        .then(Mono.just(transaction));
//                                return accountRepository.findByNumber(transaction.getPayeeAccount())
//                                        .doOnNext(account -> account.setBalance(account.getBalance() + transaction.getAmount()))
//                                        .flatMap(accountRepository::save)
//                                        .then(Mono.just(transaction));
                            }
                        }
                )
                .map(transactionMapper::fromTransaction)
                .flatMap(transaction -> ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(transaction)))
                .onErrorResume(ex -> ServerResponse.badRequest().body(fromValue(ex.getMessage())));
    }

    public Mono<ServerResponse> getTransactionById(ServerRequest request) {
        return ok().body(fromValue(transactionService.findById(UUID.fromString(request.pathVariable("id"))).map(transactionMapper::fromTransaction)));
    }

    public Mono<ServerResponse> updateTransaction(ServerRequest request) {
        return request.bodyToMono(TransactionDto.class)
                .map(transactionMapper::toTransaction)
                .flatMap(transactionService::save)
                .map(transactionMapper::fromTransaction)
                .flatMap(transaction -> ok().body(fromValue(transaction)));
    }

    public Mono<ServerResponse> deleteTransaction(ServerRequest request) {
        return ok().body(fromValue(transactionService.deleteById(UUID.fromString(request.pathVariable("id")))));
    }
}
