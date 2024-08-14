//package com.bank.authentication.security;
//
//import lombok.Data;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//@Configuration
//@EnableWebFluxSecurity
//@EnableReactiveMethodSecurity
//@Data
//public class WebSecurityConfig {
//    private final AuthenticationManager authenticationManager;
//    private final SecurityContextRepository securityContextRepository;
////    private final CorsGlobalConfiguration corsGlobalConfiguration;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    private CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("http://localhost:8081"));
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT",
//                "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(List.of("Access-Control-Allow-Origin",
//                "Authorization", "Content-Type"));
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//    @Bean
//    public SecurityWebFilterChain springSecurityWebFilterChain(ServerHttpSecurity http) {
//        return http
//                .exceptionHandling(exceptionHandlingSpec -> exceptionHandlingSpec
////                        .authenticationEntryPoint((swe, e) -> Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED)))
//                        .authenticationEntryPoint((swe, e) -> {
//                            swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//                            swe.getResponse().getHeaders().add("Content-Type", "application/json");
//                            byte[] bytes = "{\"error\":\"Unauthorized\"}".getBytes(StandardCharsets.UTF_8);
//                            DataBuffer buffer = swe.getResponse().bufferFactory().wrap(bytes);
//                            return swe.getResponse().writeWith(Flux.just(buffer));
//                        })
//                        .accessDeniedHandler((swe, e) -> Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN))))
//                .csrf(ServerHttpSecurity.CsrfSpec::disable)
////                .cors(ServerHttpSecurity.CorsSpec::disable)
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
//                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
//                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
////                .cors(cors -> cors
////                        .configurationSource(corsConfigurationSource()))
//                .authenticationManager(authenticationManager)
//                .securityContextRepository(securityContextRepository)
//                .authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec
////                        .pathMatchers(HttpMethod.DELETE).hasRole("ADMIN")
////                        .pathMatchers("/admin/**").hasRole("ADMIN")
//                        .pathMatchers("/bank/**").hasAnyRole("USER")
//                        .pathMatchers("/api/auth/**").permitAll()
//                        .pathMatchers("/api/users/**").permitAll()
////                        .pathMatchers("/api/test/**").permitAll()
////                        .pathMatchers("/login").permitAll()
//                        .pathMatchers("/", "/login", "/favicon.ico").permitAll()
//                        .anyExchange().authenticated())
//                .build();
//    }
//}
