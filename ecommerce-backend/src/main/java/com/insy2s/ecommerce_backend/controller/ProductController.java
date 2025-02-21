package com.insy2s.ecommerce_backend.controller;

import com.insy2s.ecommerce_backend.model.DTO.ProductDTO;
import com.insy2s.ecommerce_backend.service.Impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productServiceImpl.getAllProducts();
    }


    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable UUID id) {
        return productServiceImpl.getProductById(id);
    }
}
