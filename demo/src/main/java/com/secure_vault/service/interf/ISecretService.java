package com.secure_vault.service.interf;

import java.util.List;

import com.secure_vault.exceptions.SecretValidationException;
import com.secure_vault.model.Secret;

public interface ISecretService {

    void create(Secret secretToAdd) throws SecretValidationException;

    List<Secret> getAll();

    void update(Secret secretToUpdate) throws SecretValidationException;

    void delete(Secret secretToDelete) throws SecretValidationException;

    Secret findSecret(int idSecret) throws SecretValidationException;
    
}
