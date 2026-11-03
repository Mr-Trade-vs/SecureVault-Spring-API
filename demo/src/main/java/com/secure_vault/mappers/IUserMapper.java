package com.secure_vault.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.secure_vault.dto.UserRequestDTO;
import com.secure_vault.dto.UserResponseDTO;
import com.secure_vault.model.User;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    
    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    UserResponseDTO toResponse(User user);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserRequestDTO requestDTO);

}
