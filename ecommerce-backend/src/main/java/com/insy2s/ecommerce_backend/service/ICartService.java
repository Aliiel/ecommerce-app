package com.insy2s.ecommerce_backend.service;

import com.insy2s.ecommerce_backend.model.DTO.AddToCartRequest;
import com.insy2s.ecommerce_backend.model.DTO.CartDTO;
import com.insy2s.ecommerce_backend.model.DTO.UserDTO;

public interface ICartService {

    CartDTO getOrCreateCart(UserDTO userDTO);
    CartDTO addProductToCart(UserDTO userDTO, AddToCartRequest request);
}
