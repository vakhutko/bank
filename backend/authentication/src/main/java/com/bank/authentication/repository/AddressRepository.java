package com.bank.authentication.repository;

import com.bank.authentication.entity.Address;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AddressRepository extends R2dbcRepository<Address, Long> {
}
