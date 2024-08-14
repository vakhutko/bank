package com.bank.transaction.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    private UUID id;
    private String payerAccount;
    private String payeeAccount;
    private Double amount;
    private Currency currency;
    private LocalDateTime createdAt;
}
