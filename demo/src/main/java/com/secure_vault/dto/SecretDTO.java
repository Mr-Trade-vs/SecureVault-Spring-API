package com.secure_vault.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public abstract class SecretDTO {
    
    private String name;
    private String value;

}
