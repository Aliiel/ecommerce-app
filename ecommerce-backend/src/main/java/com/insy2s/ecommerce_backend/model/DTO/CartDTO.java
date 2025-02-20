package com.insy2s.ecommerce_backend.model.DTO;

import com.insy2s.ecommerce_backend.model.entities.CartItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CartDTO(
        UUID id,
        BigDecimal totalPrice,
        List<CartItem> cartItems
) {
}
