package com.insy2s.ecommerce_backend.controller;

import com.insy2s.ecommerce_backend.model.DTO.CartItemDTO;
import com.insy2s.ecommerce_backend.model.DTO.UpdateCartItemRequest;
import com.insy2s.ecommerce_backend.model.DTO.UpdateCartItemResponse;
import com.insy2s.ecommerce_backend.service.ICartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart-item")
public class CartItemController {

    private final ICartItemService cartItemService;

    @PatchMapping("/update")
    public ResponseEntity<UpdateCartItemResponse> updateCartItem(@RequestBody UpdateCartItemRequest request) {
        return ResponseEntity.ok(cartItemService.updateCartItem(request));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable UUID id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }

}
