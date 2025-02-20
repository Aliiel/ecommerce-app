package com.insy2s.ecommerce_backend.model.DTO;

import java.util.UUID;

public record UserDTO (
        UUID id,
        String email
) {
}
