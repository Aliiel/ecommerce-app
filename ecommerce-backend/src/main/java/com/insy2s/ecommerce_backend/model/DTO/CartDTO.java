package com.insy2s.ecommerce_backend.model.DTO;

import com.insy2s.ecommerce_backend.model.entities.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private UUID id;
    private CartStatus status;
    private BigDecimal totalPrice;
    private List<CartItemDTO> itemsDTO;
}
