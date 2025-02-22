package com.insy2s.ecommerce_backend.model.mappers;

import com.insy2s.ecommerce_backend.model.DTO.CartDTO;
import com.insy2s.ecommerce_backend.model.entities.Cart;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CartItemMapper.class})
public interface CartMapper {

    @Mapping(target = "itemsDTO", source = "cartItems")
    CartDTO toCartDTO(Cart cart);
    Cart toCart(CartDTO cartDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(CartDTO cartDTO, @MappingTarget Cart cart);
}
