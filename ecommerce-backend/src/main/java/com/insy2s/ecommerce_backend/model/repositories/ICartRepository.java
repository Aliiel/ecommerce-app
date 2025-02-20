package com.insy2s.ecommerce_backend.model.repositories;

import com.insy2s.ecommerce_backend.model.entities.Cart;
import com.insy2s.ecommerce_backend.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ICartRepository extends JpaRepository<Cart, UUID> {

    Optional<Cart> findByUser_Id(UUID id);

    Optional<Cart> findByUser(User user);
}
