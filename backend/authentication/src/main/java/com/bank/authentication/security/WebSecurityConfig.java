package com.bank.authentication.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {

    private final String[] publicRoutes = {"/api/v1/auth/register", "/api/v1/auth/login"};

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:8081"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("Access-Control-Allow-Origin", "Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http, AuthenticationManager authManager) {
        return http
                .exceptionHandling(exceptionHandlingSpec -> exceptionHandlingSpec
                        .authenticationEntryPoint((swe, e) -> {
                            log.error("In security web filter - authorization error: {}", e.getMessage());
                            swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                            swe.getResponse().getHeaders().add("Content-Type", "application/json");
                            byte[] bytes = "{\"error\":\"Unauthorized\"}".getBytes(StandardCharsets.UTF_8);
                            DataBuffer buffer = swe.getResponse().bufferFactory().wrap(bytes);
                            return swe.getResponse().writeWith(Flux.just(buffer));
                        })
                        .accessDeniedHandler((swe, e) -> {
                            log.error("In security web filter - forbidden: {}", e.getMessage());
                            return Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN));
                        }))
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec
                        .pathMatchers(HttpMethod.OPTIONS).permitAll()
                        .pathMatchers(publicRoutes).permitAll()
                        .pathMatchers("/api/v1/users").hasAnyRole("ADMIN", "MANAGER")
                        .anyExchange().authenticated())
                .addFilterAt(bearerAuthFilter(authManager), SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }

    private AuthenticationWebFilter bearerAuthFilter(AuthenticationManager authManager) {
        AuthenticationWebFilter bearerAuthFilter = new AuthenticationWebFilter(authManager);
        bearerAuthFilter.setServerAuthenticationConverter(new BearerTokenServerAuthenticationConverter(new JwtHandler(secret)));
        bearerAuthFilter.setRequiresAuthenticationMatcher(ServerWebExchangeMatchers.pathMatchers("/**"));
        return bearerAuthFilter;
    }
}
