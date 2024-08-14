package com.bank.authentication.repository;

import com.bank.authentication.entity.UserRole;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRoleRepository extends R2dbcRepository<UserRole, Long> {
    Flux<UserRole> findByUsrId(Long userId);

    Flux<UserRole> findByRoleId(Long roleId);

    Mono<Void> deleteByUsrId(Long userId);
}
