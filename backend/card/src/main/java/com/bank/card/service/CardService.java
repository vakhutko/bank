package com.bank.card.service;

import com.bank.card.dto.CardDto;
import com.bank.card.entity.Card;
import com.bank.card.repository.CardRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@Data
@Service
public class CardService {
    private final CardRepository cardRepository;

    public Mono<Card> addCard(Card card) {
        Random random = new Random();
        return cardRepository.save(card
                .toBuilder()
                .number(String.valueOf(random.nextLong(9999999999999999L)))
                .expirationDate(LocalDate.now().plusYears(4))
                .securityCode(String.valueOf(random.nextInt(999)))
                .pin(String.valueOf(random.nextInt(9999)))
                .status(CardDto.Status.ACTIVE)
                .createdAt(LocalDateTime.now())
                .build());
    }

    public Mono<Card> getCard(Long id) {
        return cardRepository.findById(id);
    }

    public Mono<Card> updateCard(Card card) {
        return cardRepository.save(card);
    }

    public Mono<Void> deleteCard(Long id) {
        return cardRepository.deleteById(id);
    }
}
