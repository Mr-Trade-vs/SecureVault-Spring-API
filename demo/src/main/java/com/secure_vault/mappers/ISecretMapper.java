package com.secure_vault.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.secure_vault.dto.SecretRequestDTO;
import com.secure_vault.dto.SecretResponseDTO;
import com.secure_vault.model.Secret;

@Mapper(componentModel = "spring")
public interface ISecretMapper {
    
    @Mapping(target = "id", source = "secret.id")
    @Mapping(target = "name", source = "secret.name")
    @Mapping(target = "value", source = "secret.value")
    SecretResponseDTO toResponse(Secret secret);

    @Mapping(target = "id", ignore = true)
    Secret toEntity(SecretRequestDTO requestDTO);

}
