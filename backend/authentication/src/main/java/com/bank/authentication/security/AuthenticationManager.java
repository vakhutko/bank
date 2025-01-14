package com.bank.authentication.security;

import com.bank.authentication.entity.User;
import com.bank.authentication.exception.UnauthorizedException;
import com.bank.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {
    private final UserService userService;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        CustomPrincipal principal = (CustomPrincipal) authentication.getPrincipal();
        return userService.getUserById(principal.getId())
                .filter(User::getEnabled)
                .switchIfEmpty(Mono.error(new UnauthorizedException("User disabled")))
                .map(_ -> authentication);
    }
}
