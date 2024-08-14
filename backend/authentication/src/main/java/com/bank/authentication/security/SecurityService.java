package com.bank.authentication.security;

import com.bank.authentication.entity.User;
import com.bank.authentication.exception.AuthException;
import com.bank.authentication.service.RoleService;
import com.bank.authentication.service.UserRoleService;
import com.bank.authentication.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.*;

@Component
@RequiredArgsConstructor
public class SecurityService {
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Integer expirationInSeconds;
    @Value("${jwt.issuer}")
    private String issuer;

    private Mono<TokenDetails> generateToken(User user) {
        return userRoleService.findByUserId(user.getId())
                .flatMap(r -> roleService.findById(r.getRoleId())).next()
                .flatMap(role -> {
                    Map<String, Object> claims = new HashMap<>() {{
                        put("role", role.getRole().value());
                        put("username", user.getUsername());
                    }};
                    return generateToken(claims, user.getId().toString());
                });
    }

    private Mono<TokenDetails> generateToken(Map<String, Object> claims, String subject) {
        return generateToken(new Date(System.currentTimeMillis() + expirationInSeconds * 1000L), claims, subject);
    }

    private Mono<TokenDetails> generateToken(Date expirationDate, Map<String, Object> claims, String subject) {
        Date createdDate = new Date();
        String token = Jwts.builder()
                .claims(claims)
                .issuer(issuer)
                .subject(subject)
                .issuedAt(createdDate)
                .id(UUID.randomUUID().toString())
                .expiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(Base64.getEncoder().encode(secret.getBytes())))
                .compact();
        return Mono.just(TokenDetails.builder()
                .token(token)
                .issuedAt(createdDate)
                .expiresAt(expirationDate)
                .build());
    }

    public Mono<TokenDetails> authenticate(final String username, final String password) {
        return userService.getUserByUsername(username)
                .flatMap(user -> {
                    if (!user.getEnabled()) {
                        return Mono.error(new AuthException("Account disabled", "PROSELYTE_USER_ACCOUNT_DISABLED"));
                    }
                    if (!passwordEncoder.matches(password, user.getPassword())) {
                        return Mono.error(new BadCredentialsException(username));
                    }
                    return generateToken(user)
                            .map(token -> token.toBuilder()
                                    .userId(user.getId())
                                    .build())
                            .flatMap(tokenDetails ->
                                    userRoleService.findByUserId(user.getId())
                                            .flatMap(r -> roleService.findById(r.getRoleId()))
                                            .collectList()
                                            .map(t -> tokenDetails.toBuilder().roles(t).build())
                            );
//                            .zipWith(userRoleService.findByUserId(user.getId())
//                                    .flatMap(r -> roleService.findById(r.getRoleId())).collectList())
//                            .map(t -> {
//                                TokenDetails tokenDetails = t.getT1();
//                                tokenDetails.setRoles(t.getT2());
//                                return tokenDetails;
//                            });
                })
                .switchIfEmpty(Mono.error(new UsernameNotFoundException(username)));
    }
}
