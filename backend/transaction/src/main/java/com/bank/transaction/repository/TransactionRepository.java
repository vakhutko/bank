package com.bank.transaction.repository;

import com.bank.transaction.entity.Transaction;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.UUID;

public interface TransactionRepository extends R2dbcRepository<Transaction, UUID> {
}
