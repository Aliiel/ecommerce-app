package com.insy2s.ecommerce_backend.service;

import com.insy2s.ecommerce_backend.exceptions.ResourceNotFoundException;
import com.insy2s.ecommerce_backend.model.DTO.AddToCartRequest;
import com.insy2s.ecommerce_backend.model.DTO.CartDTO;
import com.insy2s.ecommerce_backend.model.entities.Cart;
import com.insy2s.ecommerce_backend.model.entities.CartItem;
import com.insy2s.ecommerce_backend.model.entities.Product;
import com.insy2s.ecommerce_backend.model.entities.User;
import com.insy2s.ecommerce_backend.model.mappers.CartMapper;
import com.insy2s.ecommerce_backend.model.repositories.ICartRepository;
import com.insy2s.ecommerce_backend.model.repositories.IProductRepository;
import com.insy2s.ecommerce_backend.model.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final ICartRepository cartRepository;
    private final IUserRepository userRepository;
    private final IProductRepository productRepository;
    private final CartMapper cartMapper;



    public CartDTO getOrCreateCart(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Pas d'utilisateur trouvé"));

        Cart cart = cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        return cartMapper.toCartDTO(cart);
    }


    public CartDTO addProductToCart(AddToCartRequest request) {

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        Cart cart = cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    return cartRepository.save(newCart);
                });

        Product product = productRepository.findById(request.productId())
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

        Optional<CartItem> existingItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId().equals(request.productId()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + request.quantity());
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(request.quantity());
            cart.getCartItems().add(newItem);
        }

        cartRepository.save(cart);
        return cartMapper.toCartDTO(cart);
    }
}
