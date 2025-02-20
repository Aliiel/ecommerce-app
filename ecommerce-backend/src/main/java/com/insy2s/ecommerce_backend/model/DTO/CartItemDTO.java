package com.insy2s.ecommerce_backend.model.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public record CartItemDTO(
        UUID productId,
        String productName,
        BigDecimal productPrice,
        int quantity) {
}
