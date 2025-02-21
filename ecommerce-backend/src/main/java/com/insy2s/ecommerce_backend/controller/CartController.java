package com.insy2s.ecommerce_backend.controller;

import com.insy2s.ecommerce_backend.model.DTO.AddToCartRequest;
import com.insy2s.ecommerce_backend.model.DTO.CartDTO;
import com.insy2s.ecommerce_backend.model.DTO.UserDTO;
import com.insy2s.ecommerce_backend.model.entities.User;
import com.insy2s.ecommerce_backend.model.mappers.UserMapper;
import com.insy2s.ecommerce_backend.service.ICartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final ICartService cartService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<CartDTO> getCart(@AuthenticationPrincipal User user) {
        log.info("user récup du controller : " + user);
        return ResponseEntity.ok(cartService.getOrCreateCart(userMapper.toUserDTO(user)));
    }

    @PostMapping("/add")
    public ResponseEntity<CartDTO> addToCart(
            @AuthenticationPrincipal User user,
            @RequestBody AddToCartRequest request) {

        UserDTO userDTO = userMapper.toUserDTO(user);
        return ResponseEntity.ok(cartService.addProductToCart(userDTO, request));
    }
}
