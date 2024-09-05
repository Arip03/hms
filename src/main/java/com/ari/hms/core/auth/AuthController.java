package com.ari.hms.core.auth;

import com.ari.hms.core.auth.dto.request.LoginRequestDto;
import com.ari.hms.core.auth.dto.response.AuthenticationResponse;
import com.ari.hms.core.user.dto.request.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    @Autowired
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody CreateUserDto user) {
        return ResponseEntity.ok(service.create(user));
    }
}
