package com.bank.authentication.repository;

import com.bank.authentication.entity.Person;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PersonRepository extends R2dbcRepository<Person, Long> {
}
