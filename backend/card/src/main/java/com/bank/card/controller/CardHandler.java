package com.bank.card.controller;

import com.bank.card.dto.CardDto;
import com.bank.card.entity.Card;
import com.bank.card.mapper.CardMapper;
import com.bank.card.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Slf4j
@RequiredArgsConstructor
@Component
public class CardHandler {
    private final CardService cardService;
    private final CardMapper cardMapper;

    public Mono<ServerResponse> createCard(ServerRequest request) {
        return request.bodyToMono(CardDto.class)
                .map(cardMapper::toCard)
                .map(card -> card.toBuilder().accountId(Long.valueOf(request.queryParam("accountId").orElseThrow())).build())
                .flatMap(cardService::addCard)
                .map(cardMapper::fromCard)
                .flatMap(cardDto -> ServerResponse.ok().body(fromValue(cardDto)));
    }

    public Mono<ServerResponse> getCard(ServerRequest request) {
        return ServerResponse.ok().body(cardService.getCard(Long.valueOf(request.pathVariable("cardId"))), Card.class);
    }

    public Mono<ServerResponse> deleteCard(ServerRequest request) {
        return cardService.deleteCard(Long.valueOf(request.pathVariable("cardId")))
                .then(ServerResponse.noContent().build());
    }

    public Mono<ServerResponse> updateCard(ServerRequest request) {
        return request.bodyToMono(CardDto.class)
                .map(cardMapper::toCard)
                .flatMap(cardService::updateCard)
                .map(cardMapper::fromCard)
                .flatMap(cardDto -> ServerResponse.ok().body(fromValue(cardDto)));
    }
}
