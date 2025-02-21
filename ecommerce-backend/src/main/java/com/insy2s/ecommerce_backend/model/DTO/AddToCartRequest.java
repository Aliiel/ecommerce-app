package com.insy2s.ecommerce_backend.model.DTO;

import java.util.UUID;

public record AddToCartRequest(
        UUID productId,
        int quantity
) {
}
