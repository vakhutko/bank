package com.bank.user.repository;

import com.bank.user.dto.RoleDto;
import com.bank.user.entity.Role;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface RoleRepository extends R2dbcRepository<Role, Long> {
    Mono<Role> findByRole(RoleDto.Role role);
}
