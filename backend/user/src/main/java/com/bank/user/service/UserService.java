package com.bank.user.service;

import com.bank.user.entity.User;
import com.bank.user.repository.RoleRepository;
import com.bank.user.repository.UserRepository;
import com.bank.user.repository.UserRoleRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    public Flux<User> getUser() {
        return userRepository.findAll();
    }

    public Mono<User> createUser(Mono<User> userMono) {
        return userMono.flatMap(userRepository::save);
    }
}
