package com.insy2s.ecommerce_backend.service;

import com.insy2s.ecommerce_backend.model.DTO.UpdateCartItemRequest;
import com.insy2s.ecommerce_backend.model.DTO.UpdateCartItemResponse;

import java.util.UUID;

public interface ICartItemService {

    UpdateCartItemResponse updateCartItem(UpdateCartItemRequest request);
    void deleteCartItem(UUID cartItemId);
}
