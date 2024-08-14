//package com.bank.authentication.controllers;
//
//import com.bank.authentication.dto.AuthRequestDto;
//import com.bank.authentication.dto.AuthResponseDto;
//import com.bank.authentication.dto.UserDto;
//import com.bank.authentication.entity.UserEntity;
//import com.bank.authentication.mapper.UserMapper;
//import com.bank.authentication.models.ERole;
//import com.bank.authentication.models.User;
//import com.bank.authentication.repository.RoleRepository;
//import com.bank.authentication.repository.UserEntityRepository;
//import com.bank.authentication.repository.UserRepository;
////import com.bank.authentication.security.JwtUtils;
////import com.bank.authentication.service.UserService;
//import com.bank.authentication.security.CustomPrincipal;
//import com.bank.authentication.security.SecurityService;
//import com.bank.authentication.service.UserServ;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
////@CrossOrigin(origins = "http://localhost:8081", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")
//@Slf4j
////@Data
//@RequiredArgsConstructor
//@RestController
//public class UserController {
//    public static final ResponseEntity<Object> UNAUTHORIZED = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
////    private final UserService userService;
////    private final JwtUtils jwtUtil;
//    private final SecurityService securityService;
////    private final UserEntityRepository entityRepository;
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final UserServ userServ;
//    private final UserMapper userMapper;
//
//    @PostMapping("/api/v1/auth/register")
//    public Mono<UserDto> register(@RequestBody UserDto userDto) {
//        return userServ.registerUser(userMapper.map(userDto)).log().map(userMapper::map).log();
//    }
//
//    @PostMapping("/api/v1/auth/login")
//    public Mono<AuthResponseDto> login(@RequestBody AuthRequestDto dto) {
//        return securityService.authenticate(dto.getUsername(), dto.getPassword())
//                .flatMap(tokenDetails -> Mono.just(
//                        AuthResponseDto.builder()
//                                .userId(tokenDetails.getUserId())
//                                .token(tokenDetails.getToken())
//                                .issuedAt(tokenDetails.getIssuedAt())
//                                .expiresAt(tokenDetails.getExpiresAt())
//                                .build()
//                ));
//    }
//
//    @GetMapping("/api/v1/auth/info")
//    public Mono<UserDto> getUserInfo(Authentication authentication) {
//        return userServ.getUserById(((CustomPrincipal) authentication.getPrincipal()).getId()).map(userMapper::map);
//    }
//
//    @PostMapping("/api/users")
//    public Mono<ResponseEntity<Object>> createUser(@RequestBody UserEntity user) {
////        user.getRoles().forEach(role ->
////                roleRepository.findByRole(role.getRole())
////        );
////        return userRepository.save(user).log().map(ResponseEntity::ok);
//        return userServ.save(user).log().map(ResponseEntity::ok);
//    }
//
//    @GetMapping("/api/users")
//    public Flux<User> getUsers(@RequestParam(required = false) ERole role) {
////        return role != null ? userRepository.findByRoles(role).log() : userRepository.findAllWithRoles().log();
//        return role != null ? userRepository.findByRoles(role).log() : userServ.findAll().log();
//    }
//
//    @PutMapping("/api/users")
//    public Mono<ResponseEntity<Object>> updateUser(@RequestParam Long id, @RequestParam String name) {
//        return userServ.findById(id).map(user -> {
//            user.setUsername(name);
//            return userServ.update(user);
//        }).log().map(ResponseEntity::ok);
//    }
//
//    @DeleteMapping("/api/users/{id}")
//    public Mono<ResponseEntity<Object>> deleteUser(@PathVariable long id) {
//        return userServ.deleteById(id).log().then(Mono.just(ResponseEntity.ok().build()));
//    }
//
////    @PostMapping("/api/auth/signout")
////    public Mono<ResponseEntity<Object>> logout(ServerWebExchange exchange) {
////        return Mono.just(ResponseEntity.status(HttpStatus.OK).build());
////    }
////
//////    @CrossOrigin(origins = "http://localhost:8081", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")
////    @PostMapping("/api/auth/signin")
////    public Mono<ResponseEntity<?>> login(@RequestBody LoginRequest loginRequest) {
////        final Map<String, Object> body = new HashMap<>();
////        body.put("status", HttpStatus.UNAUTHORIZED);
////        body.put("error", "Unauthorized");
////        body.put("message", "Username or password is incorrect");
////        body.put("path", "http://localhost:8081");
////        return userService.findByUsername(loginRequest.getUsername())
////                .cast(User.class)
////                .map(userDetails ->
////                        Objects.equals(
////                                loginRequest.getPassword(),
////                                userDetails.getPassword()
////                        )
//////                                ? ResponseEntity.ok(jwtUtil.generateToken(userDetails))
////                                ? ResponseEntity.ok(new JwtResponse(jwtUtil.generateToken(userDetails),
////                                userDetails.getId(),
////                                userDetails.getUsername(),
////                                "vak@mail.ru",
////                                List.of(userDetails.getRoles().getFirst().getRole().name())))
////                                : ResponseEntity.status(HttpStatus.UNAUTHORIZED)
////                                .contentType(MediaType.APPLICATION_JSON)
////                                .body(body)
////                )
//////                .defaultIfEmpty(UNAUTHORIZED);
////                .defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
////                        .contentType(MediaType.APPLICATION_JSON)
////                        .body(body));
//////        return swe.getFormData()
//////                .doOnNext(log::info)
//////                .doOnNext(s -> log.info(s.toSingleValueMap()))
//////                .doOnNext(s -> log.info(s.toSingleValueMap().get("username")))
//////                .doOnNext(s -> log.info(s.toSingleValueMap().get("password")))
//////                .flatMap(credentials ->
//////                userService.findByUsername(credentials.getFirst("username"))
//////                        .cast(User.class)
//////                        .map(userDetails ->
//////                                Objects.equals(
//////                                        credentials.getFirst("password"),
//////                                        userDetails.getPassword()
//////                                )
//////                                        ? ResponseEntity.ok(jwtUtil.generateToken(userDetails))
//////                                        : UNAUTHORIZED
//////                        )
//////                        .defaultIfEmpty(UNAUTHORIZED)
//////        );
////    }
//}
