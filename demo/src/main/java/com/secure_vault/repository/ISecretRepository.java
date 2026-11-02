package com.secure_vault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.secure_vault.model.Secret;

@Service 
public interface ISecretRepository extends JpaRepository<Secret, Integer>{
    
}
