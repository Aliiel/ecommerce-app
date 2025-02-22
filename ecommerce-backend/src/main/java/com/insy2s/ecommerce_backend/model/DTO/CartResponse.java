package com.insy2s.ecommerce_backend.model.DTO;

import com.insy2s.ecommerce_backend.model.entities.CartStatus;

public record CartResponse(
        String message,
        CartStatus status
) {
}
