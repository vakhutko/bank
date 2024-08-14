package com.bank.authentication.security;

import com.bank.authentication.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class BearerTokenServerAuthenticationConverter implements ServerAuthenticationConverter {

    private final static String BEARER_TOKEN = "Bearer ";
    private static final Function<String, Mono<String>> getBearerValue = authValue -> Mono.justOrEmpty(authValue.substring(BEARER_TOKEN.length()));
    private final JwtHandler jwtHandler;

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
                .flatMap(getBearerValue)
                .flatMap(jwtHandler::verify)
                .flatMap(UserAuthenticationBearer::create)
                .onErrorResume(e -> Mono.error(new UnauthorizedException(e.getMessage())));
    }
}
