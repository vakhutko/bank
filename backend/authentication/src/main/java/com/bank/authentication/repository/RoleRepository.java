package com.bank.authentication.repository;

import com.bank.authentication.entity.Role;
import com.bank.authentication.generated.RoleDto;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface RoleRepository extends R2dbcRepository<Role, Long> {
    Mono<Role> findByRole(RoleDto.Role role);
}
