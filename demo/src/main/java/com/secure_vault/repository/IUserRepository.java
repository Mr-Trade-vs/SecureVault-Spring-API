package com.secure_vault.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.secure_vault.model.User;

@Repository 
public interface IUserRepository extends JpaRepository<User, Integer> {
    
    // Could also use @Query
    Optional<User> findFirstByOrderByIdDesc();
    
}
