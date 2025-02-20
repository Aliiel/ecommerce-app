package com.insy2s.ecommerce_backend.model.repositories;

import com.insy2s.ecommerce_backend.model.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
