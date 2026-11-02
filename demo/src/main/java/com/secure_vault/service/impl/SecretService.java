package com.secure_vault.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.secure_vault.exceptions.SecretValidationException;
import com.secure_vault.model.Secret;
import com.secure_vault.repository.ISecretRepository;
import com.secure_vault.service.interf.ISecretService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class SecretService implements ISecretService {

    private final ISecretRepository secretRepository;
    
    @Override
    public void create(Secret secretToAdd) throws SecretValidationException {
        
        checkInfo(secretToAdd);
        secretRepository.save(secretToAdd);
        
    }

    @Override
    public List<Secret> getAll() {
        
        return secretRepository.findAll();

    }

    @Override
    public void update(Secret secretToUpdate) throws SecretValidationException {
        
        checkInfo(secretToUpdate);

        findSecret(secretToUpdate.getId());

        secretRepository.save(secretToUpdate);
        
    }

    @Override
    public void delete(Secret secretToDelete) throws SecretValidationException {
        
        checkInfo(secretToDelete);

        findSecret(secretToDelete.getId());

        secretRepository.delete(secretToDelete);
        
    }

    private void checkInfo(Secret secretToCheck) throws SecretValidationException {

        if (secretToCheck == null) throw new SecretValidationException("Secret is empty, info wasn't provided");

        // We could add more restrictions below if project need it or business model requires it
        //Example: secretToCheck.getValue().lenght() < 500

    }

    @Override
    public Secret findSecret(int idSecret) throws SecretValidationException {
        
        if (idSecret < 0) throw new SecretValidationException("Id have an invalid format, check again");

        Optional<Secret> secretSearch = secretRepository.findById(idSecret);

        return secretSearch.orElseThrow(() -> new SecretValidationException("Secret is empty, info wasn't provided"));

    }

}
