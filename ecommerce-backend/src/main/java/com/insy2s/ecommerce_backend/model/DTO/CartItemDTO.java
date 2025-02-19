package com.insy2s.ecommerce_backend.model.DTO;

import java.util.UUID;

public record CartItemDTO(
        UUID productId,
        int quantity) {
}
