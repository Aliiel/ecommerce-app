package com.insy2s.ecommerce_backend.service;

import com.insy2s.ecommerce_backend.model.DTO.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface IProductService {

    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(UUID id);
}
