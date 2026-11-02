package com.secure_vault.dto;

import com.secure_vault.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data 
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class SecretRequestDTO extends SecretDTO{
    
    private User owner;

}
