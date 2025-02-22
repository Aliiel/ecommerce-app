package com.insy2s.ecommerce_backend.service;

import com.insy2s.ecommerce_backend.model.DTO.CartItemDTO;
import com.insy2s.ecommerce_backend.model.DTO.UpdateCartItemRequest;

import java.util.UUID;

public interface ICartItemService {

    CartItemDTO updateCartItem(UpdateCartItemRequest request);
    void deleteCartItem(UUID cartItemId);
}
