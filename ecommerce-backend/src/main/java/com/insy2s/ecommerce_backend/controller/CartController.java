package com.insy2s.ecommerce_backend.controller;

import com.insy2s.ecommerce_backend.model.DTO.AddToCartRequest;
import com.insy2s.ecommerce_backend.model.DTO.CartDTO;
import com.insy2s.ecommerce_backend.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public ResponseEntity<CartDTO> getCart(@RequestParam String username) {
        return ResponseEntity.ok(cartService.getOrCreateCart(username));
    }


    @PostMapping("/add")
    public ResponseEntity<CartDTO> addToCart(@RequestBody AddToCartRequest request) {
        return ResponseEntity.ok(cartService.addProductToCart(request));
    }
}
