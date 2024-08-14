package com.bank.card.repository;

import com.bank.card.entity.Card;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CardRepository extends R2dbcRepository<Card, Long> {
}
