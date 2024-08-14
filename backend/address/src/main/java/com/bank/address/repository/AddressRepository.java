package com.bank.address.repository;

import com.bank.address.entity.Address;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface AddressRepository extends R2dbcRepository<Address, Long> {
}
