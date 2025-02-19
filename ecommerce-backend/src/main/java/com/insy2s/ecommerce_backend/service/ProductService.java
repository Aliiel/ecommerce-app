package com.insy2s.ecommerce_backend.service;

import com.insy2s.ecommerce_backend.exceptions.ResourceNotFoundException;
import com.insy2s.ecommerce_backend.model.DTO.ProductDTO;
import com.insy2s.ecommerce_backend.model.entities.Product;
import com.insy2s.ecommerce_backend.model.mappers.ProductMapper;
import com.insy2s.ecommerce_backend.model.repositories.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productRepository;
    private final ProductMapper productMapper;


    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDTO)
                .toList();
    }


    public ProductDTO getProductById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Ce produit n'existe pas.")
                );
        return productMapper.toDTO(product);
    }
}
