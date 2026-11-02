package com.secure_vault.dto;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data 
@EqualsAndHashCode(callSuper = false)
@Builder
public class SecretResponseDTO extends SecretDTO {


}
