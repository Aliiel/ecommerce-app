package com.insy2s.ecommerce_backend.model.repositories;

import com.insy2s.ecommerce_backend.model.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICartRepository extends JpaRepository<Cart, UUID> {
}
