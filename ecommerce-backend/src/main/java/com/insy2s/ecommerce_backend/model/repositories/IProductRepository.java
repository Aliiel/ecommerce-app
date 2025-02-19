package com.insy2s.ecommerce_backend.model.repositories;

import com.insy2s.ecommerce_backend.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProductRepository extends JpaRepository<Product, UUID> {
}
