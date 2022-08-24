package com.ERetail.controller;

import com.ERetail.model.AppUsers;
import com.ERetail.model.Role;
import com.ERetail.service.AppUsersService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class AppUsersController {
    @Autowired
    private AppUsersService appUsersService;

    @SneakyThrows(Exception.class)
    @PostMapping("/users/save")
    public ResponseEntity<Object> saveUsers(@RequestBody AppUsers appUsers) {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/save").toUriString());

        return ResponseEntity.created(uri).body(appUsersService.saveUsers(appUsers));
    }

    @SneakyThrows(Exception.class)
    @PostMapping("/role/save")
    public ResponseEntity<Object> saveRole(@RequestBody Role role) {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

        return ResponseEntity.created(uri).body(appUsersService.saveRole(role));
    }

    @SneakyThrows(Exception.class)
    @PostMapping("/role/addroletousers")
    public ResponseEntity<Object> addRoleToUser(@RequestParam(required = true) String username,
                                                @RequestParam(required = true) String roleName) {

        appUsersService.addRoleToUser(username, roleName);

        return ResponseEntity.ok().build();
    }

    @SneakyThrows(Exception.class)
    @GetMapping("/users/{username}")
    public ResponseEntity<Object> getUsers(@PathVariable(name = "username") String username) {

        return ResponseEntity.ok().body(appUsersService.getUsers(username));
    }

    @SneakyThrows(Exception.class)
    @GetMapping("/userss")
    public ResponseEntity<Object> getUsers() {

        return ResponseEntity.ok().body(appUsersService.getUsers());
    }

    @SneakyThrows(Exception.class)
    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) {

        String authorizationHeader = request.getHeader("Authorization");

        if (Optional.ofNullable(authorizationHeader).isPresent() && authorizationHeader.startsWith("Bearer ")) {

            try {

                String refreshToken = authorizationHeader.substring("Bearer ".length());

                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());

                JWTVerifier verifier = JWT.require(algorithm).build();

                DecodedJWT decodedJWT = verifier.verify(refreshToken);

                String username = decodedJWT.getSubject();

                AppUsers users = appUsersService.getUsers(username);

                String accessToken = JWT.create().withSubject(users.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", users.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, Object> token = new HashMap<String, Object>();

                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                token.put("accessToken", accessToken);
                token.put("refreshToken", refreshToken);

                new ObjectMapper().writeValue(response.getOutputStream(), token);

            } catch (Exception e) {

                Map<String, Object> error = new HashMap<String, Object>();

                response.setHeader("error", e.getMessage());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);

                error.put("error", e.getMessage());
                error.put("status", HttpStatus.FORBIDDEN.value());

                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }

        } else {

            throw new RuntimeException("Refresh token is missing");

        }
    }
}
