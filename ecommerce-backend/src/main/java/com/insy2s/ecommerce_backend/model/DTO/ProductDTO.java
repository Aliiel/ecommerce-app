package com.insy2s.ecommerce_backend.model.DTO;


import java.math.BigDecimal;
import java.util.UUID;

public record ProductDTO (
        UUID id,
        String name,
        BigDecimal price,
        String type,
        String pictureUrl){
}
