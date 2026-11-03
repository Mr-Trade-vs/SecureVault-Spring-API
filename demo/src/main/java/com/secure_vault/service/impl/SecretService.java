package com.secure_vault.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.secure_vault.dto.SecretRequestDTO;
import com.secure_vault.dto.SecretResponseDTO;
import com.secure_vault.exceptions.SecretValidationException;
import com.secure_vault.mappers.ISecretMapper;
import com.secure_vault.model.Secret;
import com.secure_vault.repository.ISecretRepository;
import com.secure_vault.service.interf.ISecretService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class SecretService implements ISecretService {

    private final ISecretRepository secretRepository;
    private final ISecretMapper secretMapper;
    
    @Override
    public SecretResponseDTO create(SecretRequestDTO secretToAdd) throws SecretValidationException {
        
        checkInfo(secretToAdd);
        Secret secretDB = secretMapper.toEntity(secretToAdd);
        secretRepository.save(secretDB);

        //Response Conversion
        return secretMapper.toResponse(secretDB);
        
    }

    @Override
    public List<SecretResponseDTO> getAll() {
        
        List<Secret> secrets = secretRepository.findAll();

        if (secrets.isEmpty()) return new ArrayList<SecretResponseDTO>();

        List<SecretResponseDTO> secretConversion = new ArrayList<SecretResponseDTO>();
        for (Secret secret : secrets)
            secretConversion.add(secretMapper.toResponse(secret));
        return secretConversion;

    }

    @Override
    public SecretResponseDTO update(SecretRequestDTO secretToUpdate, int idSecret) throws SecretValidationException {
        
        checkInfo(secretToUpdate);

        findSecret(idSecret);

        Secret secretDB = secretMapper.toEntity(secretToUpdate);
        secretDB.setId(idSecret);

        secretRepository.save(secretDB);

        //Response Conversion
        return secretMapper.toResponse(secretDB);
        
    }

    @Override
    public SecretResponseDTO delete(int idSecretToDelete) throws SecretValidationException {

        Secret secretRemove = findSecret(idSecretToDelete);

        secretRepository.delete(secretRemove);

        //Response Conversion
        return secretMapper.toResponse(secretRemove);
        
    }

    private void checkInfo(SecretRequestDTO secretToCheck) throws SecretValidationException {

        if (secretToCheck == null) throw new SecretValidationException("Secret is empty, info wasn't provided");

        // We could add more restrictions below if project need it or business model requires it
        //Example: secretToCheck.getValue().lenght() < 500

    }

    private Secret findSecret(int idSecret) throws SecretValidationException {
        
        if (idSecret < 0) throw new SecretValidationException("Id have an invalid format, check again");

        Optional<Secret> secretSearch = secretRepository.findById(idSecret);

        return secretSearch.orElseThrow(() -> new SecretValidationException("Secret is empty, info wasn't provided"));

    }

}
