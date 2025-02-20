package com.insy2s.ecommerce_backend.model.DTO;

import java.util.UUID;

public record AddToCartRequest(
        String email,
        UUID productId,
        int quantity
) {
}
