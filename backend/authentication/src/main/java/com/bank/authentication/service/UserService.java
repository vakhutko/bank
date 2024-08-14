package com.bank.authentication.service;

import com.bank.authentication.entity.User;
import com.bank.authentication.repository.RoleRepository;
import com.bank.authentication.repository.UserRepository;
import com.bank.authentication.repository.UserRoleRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@Data
@Service
public class UserService {
    private final UserRepository entityRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    public Mono<User> findById(Long id) {
        return entityRepository.findById(id);
    }

    public Mono<User> registerUser(User user) {
        return Mono.just(user.toBuilder()
                        .password(passwordEncoder.encode(user.getPassword()))
                        .enabled(true)
                        .createdAt(LocalDateTime.now())
                        .updatedAt(LocalDateTime.now())
                        .build())
                .flatMap(this::save)
                .doOnSuccess(userEntity -> log.info("IN registerUser: {}", userEntity.toString()));
    }

    public Mono<User> getUserById(Long id) {
        return entityRepository.findById(id);
//                .flatMap(user -> Mono.just(user)
//                        .zipWith(userRoleRepository.findByUsrId(user.getId())
//                                .flatMap(userRole -> roleRepository.findById(userRole.getRoleId()))
//                                .collectList())
//                        .map(tuple -> tuple.getT1().withRoles(tuple.getT2())));
    }

    public Mono<User> getUserByUsername(String username) {
        return entityRepository.findByUsername(username);
    }

    public Flux<User> findAll() {
        return entityRepository.findAll();
    }

    public Mono<User> save(User user) {
        return entityRepository.save(user).log();
    }

    public Mono<User> update(User user) {
        return entityRepository.save(user)
                .doOnNext(u -> log.info("User updated : {}", u));
//                .doOnNext(u -> user.setId(u.getId()))
//                .zipWith(
//                        userRoleRepository.findByUsrId(user.getId())
//                                .flatMap(e -> roleRepository.findById(e.getRoleId()))
//                                .collectList()
//                )
//                .map(tuple -> tuple.getT1().withRoles(tuple.getT2()));
    }

    public Mono<Void> deleteById(Long id) {
        return userRoleRepository.deleteByUsrId(id)
                .then(entityRepository.deleteById(id));
    }
}
