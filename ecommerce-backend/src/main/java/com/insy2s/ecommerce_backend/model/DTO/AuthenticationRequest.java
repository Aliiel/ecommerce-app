package com.insy2s.ecommerce_backend.model.DTO;

public record AuthenticationRequest (
        String email,
        String password
) {
}
