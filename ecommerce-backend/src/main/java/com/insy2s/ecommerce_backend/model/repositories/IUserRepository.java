package com.insy2s.ecommerce_backend.model.repositories;

import com.insy2s.ecommerce_backend.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
