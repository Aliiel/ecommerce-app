package com.insy2s.ecommerce_backend.model.mappers;

import com.insy2s.ecommerce_backend.model.DTO.CartItemDTO;
import com.insy2s.ecommerce_backend.model.entities.CartItem;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartItemMapper {

    CartItemDTO toDTO(CartItem cartItem);

    CartItem toEntity(CartItemDTO cartItemDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(CartItemDTO cartItemDTO, @MappingTarget CartItem cartItem);

}
