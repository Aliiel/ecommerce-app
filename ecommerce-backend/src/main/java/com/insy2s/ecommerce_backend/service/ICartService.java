package com.insy2s.ecommerce_backend.service;

import com.insy2s.ecommerce_backend.model.DTO.AddToCartRequest;
import com.insy2s.ecommerce_backend.model.DTO.CartDTO;
import com.insy2s.ecommerce_backend.model.DTO.CartResponse;
import com.insy2s.ecommerce_backend.model.DTO.UserDTO;

public interface ICartService {

    CartDTO getOrCreateCart(UserDTO userDTO);
    CartResponse addProductToCart(UserDTO userDTO, AddToCartRequest request);
    CartResponse validateCart(UserDTO userDTO);
}
