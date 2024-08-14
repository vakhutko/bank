package com.bank.transaction.service;

import com.bank.transaction.entity.Transaction;
import com.bank.transaction.repository.TransactionRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Data
@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public Mono<Transaction> save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Flux<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Mono<Transaction> findById(UUID id) {
        return transactionRepository.findById(id);
    }

    public Mono<Void> deleteById(UUID id) {
        return transactionRepository.deleteById(id);
    }
}
