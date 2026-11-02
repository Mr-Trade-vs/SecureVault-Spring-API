package com.secure_vault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.secure_vault.model.Secret;

@Repository 
public interface ISecretRepository extends JpaRepository<Secret, Integer>{
    
}
