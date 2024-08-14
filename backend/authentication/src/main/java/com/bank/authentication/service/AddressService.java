package com.bank.authentication.service;

import com.bank.authentication.entity.Address;
import com.bank.authentication.repository.AddressRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Data
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public Mono<Address> save(Address address) {
        return addressRepository.save(address);
    }
}
