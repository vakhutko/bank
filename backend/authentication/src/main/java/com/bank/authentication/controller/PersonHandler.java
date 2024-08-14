package com.bank.authentication.controller;

import com.bank.authentication.dto.AccountDto;
import com.bank.authentication.dto.AddressDto;
import com.bank.authentication.dto.PersonDto;
import com.bank.authentication.entity.UserRole;
import com.bank.authentication.generated.RoleDto;
import com.bank.authentication.mapper.PersonMapper;
import com.bank.authentication.mapper.RoleMapper;
import com.bank.authentication.mapper.UserMapper;
import com.bank.authentication.service.PersonService;
import com.bank.authentication.service.RoleService;
import com.bank.authentication.service.UserRoleService;
import com.bank.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@RequiredArgsConstructor
@Component
public class PersonHandler {
    private final PersonService personService;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final RoleService roleService;
    private final PersonMapper personMapper;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    @Transactional(rollbackFor = Exception.class)
    public Mono<ServerResponse> createPerson(ServerRequest request) {
//        WebClient client = WebClient.create("http://localhost:8081");
//        WebClient addressClient = WebClient.create("http://localhost:8086");
        return request.bodyToMono(PersonDto.class)
                .flatMap(personDto -> Mono.just(personDto)
                                .zipWith(Mono.just(personMapper.toPerson(personDto)))
                                .zipWith(createAddress(personDto.getAddress()))
//                                .zipWith(addressService.save(addressMapper.toAddress(personDto.getAddress())))
                                .flatMap(tuple2 -> Mono.just(tuple2.getT1().getT1().toBuilder().address(tuple2.getT2()).build())
                                        .zipWith(Mono.just(tuple2.getT1().getT2().toBuilder().addressId(tuple2.getT2().getId()).build())))
                                .zipWith(createAccount())
//                        .zipWith(client
//                                .post()
//                                .uri("/accounts")
//                                .accept(MediaType.APPLICATION_JSON)
//                                .retrieve()
//                                .bodyToMono(AccountDto.class))
                                .flatMap(tuple2 -> Mono.just(tuple2.getT1().getT1().toBuilder().account(tuple2.getT2()).build())
                                        .zipWith(Mono.just(tuple2.getT1().getT2().toBuilder().accountId(tuple2.getT2().getId()).build())))
                                .zipWith(userService.registerUser(userMapper.toUser(personDto.getUser()))
                                        .map(userMapper::fromUser)
                                        .zipWith(roleService.findByRole(RoleDto.Role.ROLE_USER))
                                        .flatMap(tuple2 -> userRoleService.save(new UserRole(tuple2.getT1().getId(), tuple2.getT2().getId()))
                                                .then(Mono.just(tuple2.getT1().withRoles(List.of(roleMapper.fromRole(tuple2.getT2())))))))
                                .flatMap(tuple2 -> Mono.just(tuple2.getT1().getT1().toBuilder().user(tuple2.getT2()).build())
                                        .zipWith(Mono.just(tuple2.getT1().getT2().toBuilder().userId(tuple2.getT2().getId()).build())))
                )
                .flatMap(tuple2 -> personService.save(tuple2.getT2()).map(person -> tuple2.getT1().toBuilder().id(person.getId()).build()))
                .flatMap(person -> ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(person)))
                .doOnError(throwable -> log.error(throwable.getMessage()));
    }

    private Mono<AccountDto> createAccount() {
        return WebClient.create("http://localhost:8081")
                .post()
                .uri("/accounts")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AccountDto.class);
    }

    private Mono<AddressDto> createAddress(AddressDto addressDto) {
        return WebClient.create("http://localhost:8086")
                .post()
                .uri("/addresses")
                .accept(MediaType.APPLICATION_JSON)
                .body(fromValue(addressDto))
                .retrieve()
                .bodyToMono(AddressDto.class);
    }

//    @Transactional(rollbackFor = Exception.class)
//    public Mono<ServerResponse> createPerson(ServerRequest request) {
//        return request.bodyToMono(PersonDto.class)
//                .flatMap(personDto -> Mono.just(personDto)
//                        .zipWith(Mono.just(personMapper.toPerson(personDto)))
//                        .zipWith(addressService.save(addressMapper.toAddress(personDto.getAddress())))
//                        .flatMap(tuple2 -> Mono.just(tuple2.getT1().getT1().toBuilder().address(addressMapper.fromAddress(tuple2.getT2())).build())
//                                .zipWith(Mono.just(tuple2.getT1().getT2().toBuilder().addressId(tuple2.getT2().getId()).build())))
//                        .zipWith(accountService.save(accountMapper.toAccount(personDto.getAccount())))
//                        .flatMap(tuple2 -> Mono.just(tuple2.getT1().getT1().toBuilder().account(accountMapper.fromAccount(tuple2.getT2())).build())
//                                .zipWith(Mono.just(tuple2.getT1().getT2().toBuilder().accountId(tuple2.getT2().getId()).build())))
//                        .zipWith(userService.registerUser(userMapper.toUser(personDto.getUser()))
//                                .map(userMapper::fromUser)
//                                .zipWith(roleService.findByRole(RoleDto.Role.ROLE_USER))
//                                .flatMap(tuple2 -> userRoleService.save(new UserRole(tuple2.getT1().getId(), tuple2.getT2().getId()))
//                                        .then(Mono.just(tuple2.getT1().withRoles(List.of(roleMapper.fromRole(tuple2.getT2()))))))
//                        )
//                        .flatMap(tuple2 -> Mono.just(tuple2.getT1().getT1().toBuilder().user(tuple2.getT2()).build())
//                                .zipWith(Mono.just(tuple2.getT1().getT2().toBuilder().usrId(tuple2.getT2().getId()).build())))
//                )
//                .flatMap(tuple2 -> personService.save(tuple2.getT2()).map(person -> tuple2.getT1().toBuilder().id(person.getId()).build()))
//                .flatMap(person -> ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(person)));
//    }
}
