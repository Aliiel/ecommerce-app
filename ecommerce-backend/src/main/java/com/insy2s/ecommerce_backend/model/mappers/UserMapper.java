package com.insy2s.ecommerce_backend.model.mappers;

import com.insy2s.ecommerce_backend.model.DTO.UserDTO;
import com.insy2s.ecommerce_backend.model.entities.User;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(UserDTO userDTO, @MappingTarget User user);
}
