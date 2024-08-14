package com.bank.authentication.service;

import com.bank.authentication.entity.UserRole;
import com.bank.authentication.repository.UserRoleRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Data
@Service
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public Mono<UserRole> save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public Flux<UserRole> findByUserId(Long userId) {
        return userRoleRepository.findByUsrId(userId);
    }

    public Flux<UserRole> findByRoleId(Long roleId) {
        return userRoleRepository.findByRoleId(roleId);
    }

    public Mono<Void> deleteByUserId(Long userId) {
        return userRoleRepository.deleteByUsrId(userId);
    }
}
