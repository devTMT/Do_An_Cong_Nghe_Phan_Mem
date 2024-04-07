package com.masterspring.backenddayoff.controller;

import com.masterspring.backenddayoff.dto.request.AuthRequest;
import com.masterspring.backenddayoff.entity.User;
import com.masterspring.backenddayoff.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody AuthRequest authRequest) {
        var loggedUser = authService.login(authRequest);
        return new ResponseEntity<>(loggedUser, HttpStatus.OK);
    }
}
