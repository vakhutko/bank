package com.bank.authentication.controller;

import com.bank.authentication.dto.AuthRequestDto;
import com.bank.authentication.dto.AuthResponseDto;
import com.bank.authentication.entity.User;
import com.bank.authentication.entity.UserRole;
import com.bank.authentication.generated.RoleDto;
import com.bank.authentication.generated.UserDto;
import com.bank.authentication.mapper.RoleMapper;
import com.bank.authentication.mapper.UserMapper;
import com.bank.authentication.security.CustomPrincipal;
import com.bank.authentication.security.SecurityService;
import com.bank.authentication.service.RoleService;
import com.bank.authentication.service.UserRoleService;
import com.bank.authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserHandler {
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final SecurityService securityService;

    public Mono<ServerResponse> register(ServerRequest request) {
        return request.bodyToMono(UserDto.class)
                .flatMap(userDto -> userService.registerUser(userMapper.toUser(userDto))
                        .map(userMapper::fromUser)
                        .map(user -> user.withRoles(userDto.getRoles()))
                )
                .flatMap(userDto -> Flux.fromIterable(userDto.getRoles())
                        .flatMap(roleDto -> roleService.findByRole(roleDto.getRole()))
                        .map(roleMapper::fromRole)
                        .flatMap(roleDto -> userRoleService.save(new UserRole(userDto.getId(), roleDto.getId())))
                        .flatMap(userRole -> roleService.findById(userRole.getRoleId()))
                        .map(roleMapper::fromRole)
                        .collectList()
                        .map(userDto::withRoles)
                )
                .doOnNext(userDto -> userDto.setPassword("**********"))
                .flatMap(u -> ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(u)));
    }

    public Mono<ServerResponse> login(ServerRequest request) {
        return request.bodyToMono(AuthRequestDto.class)
                .flatMap(auth -> securityService.authenticate(auth.getUsername(), auth.getPassword()))
                .flatMap(tokenDetails -> Mono.just(AuthResponseDto.builder()
                        .userId(tokenDetails.getUserId())
                        .token(tokenDetails.getToken())
                        .issuedAt(tokenDetails.getIssuedAt())
                        .expiresAt(tokenDetails.getExpiresAt())
                        .roles(tokenDetails.getRoles())
                        .build()))
                .flatMap(a -> ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(a)));
    }

    public Mono<ServerResponse> logout(ServerRequest request) {
        return ok().build();
    }

    public Mono<ServerResponse> info(ServerRequest request) {
        return request.principal()
                .map(a -> ((Authentication) a).getPrincipal())
                .cast(CustomPrincipal.class)
                .flatMap(p -> userService.getUserById(p.getId()))
                .map(userMapper::fromUser)
                .flatMap(this::userWithRoles)
                .flatMap(a -> ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(a)))
                .onErrorResume(t -> ServerResponse.status(HttpStatus.UNAUTHORIZED).body(fromValue(t.getMessage())));
    }

    public Mono<ServerResponse> getUsers(ServerRequest request) {
        Flux<User> users;
        if (request.queryParam("role").isPresent()) {
            users = roleService
                    .findByRole(RoleDto.Role.valueOf(request.queryParam("role").orElseThrow()))
                    .flatMapMany(role -> userRoleService.findByRoleId(role.getId())
                            .flatMap(userRole -> userService.findById(userRole.getUsrId())));
        } else {
            users = userService.findAll();
        }
        return users
                .map(userMapper::fromUser)
                .flatMap(this::userWithRoles)
                .collectList()
                .flatMap(u -> ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(u)));
    }

    public Mono<ServerResponse> updateUser(ServerRequest request) {
        return userService.findById(Long.valueOf(request.queryParam("id").orElseThrow()))
                .flatMap(user -> {
                    user.setUsername(request.queryParam("username").orElseThrow());
                    return userService.update(user);
                })
                .log()
                .map(userMapper::fromUser)
                .flatMap(this::userWithRoles)
                .flatMap(u -> ok().contentType(MediaType.APPLICATION_JSON).body(fromValue(u)));
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        return userService.deleteById(Long.valueOf(request.pathVariable("id")))
                .then(ok().build());
    }

    public Mono<UserDto> userWithRoles(UserDto userDto) {
        return Mono.just(userDto)
                .map(user -> user.withPassword("**********"))
                .flatMap(user -> userRoleService.findByUserId(user.getId())
                        .flatMap(userRole -> roleService.findById(userRole.getRoleId()))
                        .map(roleMapper::fromRole)
                        .collectList()
                        .map(user::withRoles));
    }
}
