package com.bank.card.entity;

import com.bank.card.dto.CardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
public class Card {
    @Id
    private Long id;
    private String number;
    private LocalDate expirationDate;
    private String securityCode;
    private String pin;
    private CardDto.Type type; // 1 - VISA, 2 - MASTERCARD, 3 - AMEX, 4 - DISCOVER, 5 - JCB, 6 - MAESTRO, 7 - МИР
    private CardDto.Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Long accountId;
}
