package com.bank.address.controller;

import com.bank.address.dto.AddressDto;
import com.bank.address.entity.Address;
import com.bank.address.mapper.AddressMapper;
import com.bank.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Slf4j
@RequiredArgsConstructor
@Component
public class AddressHandler {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    public Mono<ServerResponse> getAllAddresses(ServerRequest request) {
        return addressService.findAll()
                .map(addressMapper::fromAddress)
                .collectList()
                .flatMap(addresses -> ServerResponse.ok().body(fromValue(addresses)));
    }

    public Mono<ServerResponse> getAddressById(ServerRequest request) {
        return Mono.just(Long.parseLong(request.pathVariable("id")))
                .flatMap(addressService::findById)
                .map(addressMapper::fromAddress)
                .flatMap(address -> ServerResponse.ok().body(fromValue(address)));
    }

    public Mono<ServerResponse> createAddress(ServerRequest request) {
        return request.bodyToMono(AddressDto.class)
                .map(addressMapper::toAddress)
                .flatMap(addressService::save)
                .map(addressMapper::fromAddress)
                .flatMap(address -> ServerResponse.ok().body(fromValue(address)));
    }

    public Mono<ServerResponse> updateAddress(ServerRequest request) {
        return request.bodyToMono(Address.class)
                .flatMap(addressService::update)
                .map(addressMapper::fromAddress)
                .flatMap(address -> ServerResponse.ok().body(fromValue(address)));
    }

    public Mono<ServerResponse> deleteAddress(ServerRequest request) {
        return Mono.just(Long.parseLong(request.pathVariable("id")))
                .flatMap(addressService::deleteById)
                .then(ServerResponse.ok().build());
    }
}
