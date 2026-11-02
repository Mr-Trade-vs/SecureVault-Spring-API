package com.secure_vault.service.interf;

import java.util.List;

import com.secure_vault.dto.SecretRequestDTO;
import com.secure_vault.dto.SecretResponseDTO;
import com.secure_vault.exceptions.SecretValidationException;

public interface ISecretService {

    SecretResponseDTO create(SecretRequestDTO secretToAdd) throws SecretValidationException;

    List<SecretResponseDTO> getAll();

    SecretResponseDTO update(SecretRequestDTO secretToUpdate, int idSecret) throws SecretValidationException;

    SecretResponseDTO delete(int idSecretToDelete) throws SecretValidationException;
    
}
