package com.secure_vault.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Role {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

}
