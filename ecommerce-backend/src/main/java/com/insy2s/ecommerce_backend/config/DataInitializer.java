package com.insy2s.ecommerce_backend.config;

import com.insy2s.ecommerce_backend.model.entities.Product;
import com.insy2s.ecommerce_backend.model.entities.Role;
import com.insy2s.ecommerce_backend.model.repositories.IProductRepository;
import com.insy2s.ecommerce_backend.model.repositories.IRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final IProductRepository productRepository;
    private final IRoleRepository roleRepository;

    @Bean
    CommandLineRunner initData() {
        return args -> {
            if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
                roleRepository.save(new Role(null, "ROLE_ADMIN"));
            }
            if (roleRepository.findByName("ROLE_USER").isEmpty()) {
                roleRepository.save(new Role(null, "ROLE_USER"));
            }
            if (productRepository.count() == 0) {
                List<Product> products = List.of(
                        new Product(null, "Ordinateur Portable", BigDecimal.valueOf(899.99), "Électronique", null),
                        new Product(null, "Smartphone", BigDecimal.valueOf(699.99), "Électronique", null),
                        new Product(null, "Casque Bluetooth", BigDecimal.valueOf(129.99), "Accessoires", null),
                        new Product(null, "Montre Connectée", BigDecimal.valueOf(199.99), "Électronique", null),
                        new Product(null, "Chaussures de Sport", BigDecimal.valueOf(79.99), "Mode", null),
                        new Product(null, "Sac à Dos", BigDecimal.valueOf(49.99), "Accessoires", null),
                        new Product(null, "Switch", BigDecimal.valueOf(299.99), "Consoles", null)
                );

                productRepository.saveAll(products);
                log.info("✅ Produits insérés avec succès !");
            } else {
                log.info("✅ Les produits existent déjà en base, aucune insertion nécessaire.");
            }
        };
    }
}
