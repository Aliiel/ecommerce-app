package com.insy2s.ecommerce_backend.service.Impl;

import com.insy2s.ecommerce_backend.exceptions.ResourceNotFoundException;
import com.insy2s.ecommerce_backend.model.DTO.CartItemDTO;
import com.insy2s.ecommerce_backend.model.DTO.UpdateCartItemRequest;
import com.insy2s.ecommerce_backend.model.entities.CartItem;
import com.insy2s.ecommerce_backend.model.mappers.CartItemMapper;
import com.insy2s.ecommerce_backend.model.repositories.ICartItemRepository;
import com.insy2s.ecommerce_backend.service.ICartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements ICartItemService {

    private final ICartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;

    @Override
    public CartItemDTO updateCartItem(UpdateCartItemRequest request) {
        CartItem cartItem = cartItemRepository.findById(request.id()).orElseThrow(() -> new ResourceNotFoundException("Pas de produit trouvé"));
        cartItem.setQuantity(request.quantity());
        return cartItemMapper.toCartItemDTO(cartItemRepository.save(cartItem));
    }


    @Override
    public void deleteCartItem(UUID cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        cartItemRepository.delete(cartItem);
    }
}
