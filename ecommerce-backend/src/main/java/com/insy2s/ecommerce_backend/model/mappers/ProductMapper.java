package com.insy2s.ecommerce_backend.model.mappers;

import com.insy2s.ecommerce_backend.model.DTO.ProductDTO;
import com.insy2s.ecommerce_backend.model.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);
}
