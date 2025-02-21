package com.insy2s.ecommerce_backend.service.Impl;

import com.insy2s.ecommerce_backend.model.DTO.*;
import com.insy2s.ecommerce_backend.model.entities.*;
import com.insy2s.ecommerce_backend.model.mappers.CartMapper;
import com.insy2s.ecommerce_backend.model.mappers.ProductMapper;
import com.insy2s.ecommerce_backend.model.mappers.UserMapper;
import com.insy2s.ecommerce_backend.model.repositories.ICartRepository;
import com.insy2s.ecommerce_backend.service.ICartService;
import com.insy2s.ecommerce_backend.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final ICartRepository cartRepository;
    private final IProductService productService;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;
    private final CartMapper cartMapper;


    @Override
    public CartDTO getOrCreateCart(UserDTO userDTO) {

        log.info("userDTO: " + userDTO);
        User user = userMapper.toUser(userDTO);
        log.info("User: {}", user);

        Cart cart = cartRepository.findByStatusAndUser(CartStatus.PENDING, user)
                .orElseGet(() -> {
                    Cart newCart = new Cart();
                    newCart.setUser(user);
                    newCart.setStatus(CartStatus.PENDING);
                    return cartRepository.save(newCart);
                });

        return cartMapper.toCartDTO(cart);
    }


    @Override
    public CartDTO addProductToCart(UserDTO userDTO, AddToCartRequest request) {

        CartDTO cartDTO = getOrCreateCart(userDTO);
        Cart cart = cartRepository.findByUser_Id(userDTO.id())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        cartMapper.partialUpdate(cartDTO, cart);

        ProductDTO productDTO = productService.getProductById(request.productId());
        Product product = productMapper.toEntity(productDTO);

        List<CartItem> cartItems = cart.getCartItems();

        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem cartItem = existingItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + request.quantity());

        }  else {

            CartItem newCartItem = new CartItem();
            newCartItem.setCart(cart);
            newCartItem.setProduct(product);
            newCartItem.setQuantity(request.quantity());
            cartItems.add(newCartItem);
        }

        cart.setCartItems(cartItems);
        cartRepository.save(cart);

        return cartMapper.toCartDTO(cart);
    }
}
