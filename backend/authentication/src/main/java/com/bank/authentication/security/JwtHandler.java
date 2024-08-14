package com.bank.authentication.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import reactor.core.publisher.Mono;

import java.util.Base64;

public class JwtHandler {

    private final String secret;

    public JwtHandler(String secret) {
        this.secret = secret;
    }

    public Mono<VerificationResult> verify(String token) {
        return Mono.just(new VerificationResult(Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(Base64.getEncoder().encode(secret.getBytes())))
                .build()
                .parseSignedClaims(token)
                .getPayload(), token));
    }

    public static class VerificationResult {
        public Claims claims;
        public String token;

        public VerificationResult(Claims claims, String token) {
            this.claims = claims;
            this.token = token;
        }
    }
}
