package com.bank.account.service;

import com.bank.account.entity.Account;
import com.bank.account.repository.AccountRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Random;

@Slf4j
@Data
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public Mono<Account> getAccountByNumber(String number) {
        return accountRepository.findByNumber(number);
    }

    public Mono<Account> updateAccount(String accountNumber, String balance) {
        return accountRepository.findByNumber(accountNumber)
                .flatMap(account -> {
                    account.setBalance(account.getBalance() + Double.parseDouble(balance));
                    return accountRepository.save(account);
                });
    }

    public Mono<Account> createAccount() {
        return accountRepository.save(new Account().toBuilder().type("DEBIT").number("40" + new Random().nextLong(999999999999999999L)).balance(0.0).dateOpened(LocalDate.now()).status("START").build());
    }
}
