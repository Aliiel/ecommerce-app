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
                        // Bougies parfumées
                        new Product(null, "Bougie parfumée à la vanille", BigDecimal.valueOf(10.99), "Bougies parfumées", "assets/vanille-1.jpg"),
                        new Product(null, "Bougie parfumée au bois de santal", BigDecimal.valueOf(14.99), "Bougies parfumées", "assets/bougie-vegetale-parfumee-bois-de-santal-180g.jpg"),
                        new Product(null, "Bougie parfumée au patchouli", BigDecimal.valueOf(11.99), "Bougies parfumées", "assets/bougie-parfumee-patchouli.jpg"),
                        new Product(null, "Bougie parfumée aux fruits rouges", BigDecimal.valueOf(13.99), "Bougies parfumées", "assets/bougie-parfumee-fruitsrouges.jpg"),
                        // Bougies chauffe-plat
                        new Product(null, "Bougie chauffe-plat blanche, lot de 12", BigDecimal.valueOf(5.99), "Bougies chauffe-plat", "assets/bougie-chauffe-plat-blanc-x8.jpg"),
                        new Product(null, "Bougie chauffe-plat parfumée à la vanille, lot de 12", BigDecimal.valueOf(6.49), "Bougies chauffe-plat", "assets/lot-de-30-bougies-parfumees-nina-37cm-vanille.jpg"),
                        new Product(null, "Bougie chauffe-plat parfumée aux fruits rouges, lot de 12", BigDecimal.valueOf(6.99), "Bougies chauffe-plat", "assets/30-bougies-chauffe-plat-parfumees-fruits-rouge.jpg"),
                        new Product(null, "Bougie chauffe-plat parfumée à la lavande, lot de 12", BigDecimal.valueOf(7.49), "Bougies chauffe-plat", "assets/71CMnjlZiWL.jpg"),
                        // Encens
                        new Product(null, "Encens à la lavande, boîte de 20 bâtonnets", BigDecimal.valueOf(3.99), "Encens", "assets/RackMultipart20240321-2-4hspfs.jpg"),
                        new Product(null, "Encens au bois de santal, boîte de 20 bâtonnets", BigDecimal.valueOf(4.49), "Encens", "assets/RackMultipart20240321-2-4hspfs.jpg"),
                        new Product(null, "Encens à la rose, boîte de 20 bâtonnets", BigDecimal.valueOf(4.99), "Encens", "assets/RackMultipart20240321-2-4hspfs.jpg"),
                        new Product(null, "Encens au patchouli, boîte de 20 bâtonnets", BigDecimal.valueOf(5.49), "Encens", "assets/RackMultipart20240321-2-4hspfs.jpg"),
                        new Product(null, "Encens au jasmin, boîte de 20 bâtonnets", BigDecimal.valueOf(4.99), "Encens", "assets/RackMultipart20240321-2-4hspfs.jpg"),
                        // Fondants parfumés
                        new Product(null, "Fondants de cire parfumé vanille - lot de 8", BigDecimal.valueOf(3.99), "Encens", "assets/71dBeJdHfXL._AC_SL1500_.jpg"),
                        new Product(null, "Fondants de cire parfumé monoï - lot de 8", BigDecimal.valueOf(4.49), "Encens", "assets/81Puqb6QBTL._AC_SL1500_.jpg"),
                        // Accessoires
                        new Product(null, "Porte-encens en bois simple", BigDecimal.valueOf(5.99), "Accessoires", "assets/porte-encens-gondole-bois-aromandise.jpg"),
                        new Product(null, "Porte-encens bois coffret éléphant", BigDecimal.valueOf(11.99), "Accessoires", "assets/porte_encens_bois_coffret_elephants_poen-0134_1_1_bis0.jpg"),
                        new Product(null, "Porte-bougie", BigDecimal.valueOf(8.99), "Accessoires", "assets/porte-bougie-soleil.jpg"),
                        new Product(null, "Brûle-parfum noir", BigDecimal.valueOf(19.99), "Accessoires", "assets/brule-parfum-noir-800x900-1.jpg")
                );

                productRepository.saveAll(products);
                log.info("✅ Produits insérés avec succès !");
            } else {
                log.info("✅ Les produits existent déjà en base, aucune insertion nécessaire.");
            }
        };
    }
}
