package com.secure_vault.dto;

import com.secure_vault.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class SecretRequestDTO {
    
    private String name;
    private String value;
    private User owner;

}
