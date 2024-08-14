package com.bank.address.service;

import com.bank.address.entity.Address;
import com.bank.address.repository.AddressRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Data
@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public Mono<Address> save(Address address) {
        return addressRepository.save(address);
    }

    public Flux<Address> findAll() {
        return addressRepository.findAll();
    }

    public Mono<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    public Mono<Void> deleteById(Long id) {
        return addressRepository.deleteById(id);
    }

    public Mono<Address> update(Address address) {
        return addressRepository.save(address);
    }
}
