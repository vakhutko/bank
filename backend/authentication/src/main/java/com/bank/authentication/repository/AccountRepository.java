package com.bank.authentication.repository;

import com.bank.authentication.entity.Account;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AccountRepository extends R2dbcRepository<Account, Long> {
}
