package com.secure_vault.service.interf;

import java.util.List;

import com.secure_vault.dto.SecretRequestDTO;
import com.secure_vault.dto.SecretResponseDTO;
import com.secure_vault.exceptions.SecretValidationException;
import com.secure_vault.model.Secret;

public interface ISecretService {

    SecretResponseDTO create(SecretRequestDTO secretToAdd) throws SecretValidationException;

    List<Secret> getAll();

    SecretResponseDTO update(SecretRequestDTO secretToUpdate, int idSecret) throws SecretValidationException;

    SecretResponseDTO delete(int idSecretToDelete) throws SecretValidationException;

    Secret findSecret(int idSecret) throws SecretValidationException;
    
}
