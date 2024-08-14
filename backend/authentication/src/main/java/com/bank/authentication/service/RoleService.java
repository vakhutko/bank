package com.bank.authentication.service;

import com.bank.authentication.entity.Role;
import com.bank.authentication.generated.RoleDto;
import com.bank.authentication.repository.RoleRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Data
@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public Flux<Role> findAll() {
        return roleRepository.findAll();
    }

    public Mono<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    public Mono<Role> findByRole(RoleDto.Role role) {
        return roleRepository.findByRole(role);
    }
}
