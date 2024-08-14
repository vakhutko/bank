package com.bank.authentication.service;

import com.bank.authentication.entity.Account;
import com.bank.authentication.repository.AccountRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Data
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public Mono<Account> save(Account account) {
        return accountRepository.save(account);
    }
}
