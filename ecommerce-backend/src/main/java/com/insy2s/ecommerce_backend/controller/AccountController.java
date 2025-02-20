package com.insy2s.ecommerce_backend.controller;

import com.insy2s.ecommerce_backend.model.DTO.AuthenticationRequest;
import com.insy2s.ecommerce_backend.model.DTO.AuthenticationResponse;
import com.insy2s.ecommerce_backend.model.DTO.RegistrationRequest;
import com.insy2s.ecommerce_backend.model.DTO.RegistrationResponse;
import com.insy2s.ecommerce_backend.security.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/registration")
    public ResponseEntity<RegistrationResponse> register(@Valid @RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(accountService.registerUser(request));
    }

    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(accountService.authenticate(request));
    }
}
