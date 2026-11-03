package com.secure_vault.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure_vault.dto.SecretRequestDTO;
import com.secure_vault.dto.SecretResponseDTO;
import com.secure_vault.service.interf.ISecretService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/users/secrets")
@RequiredArgsConstructor 
public class SecretController {

    private final ISecretService secretService;

    @GetMapping 
    public ResponseEntity<List<SecretResponseDTO>> getAll() {

        List<SecretResponseDTO> secrets = secretService.getAll();
        return ResponseEntity.ok(secrets);

    }

    @PostMapping("/save")
    public ResponseEntity<SecretResponseDTO> addSecret(@RequestBody SecretRequestDTO requestDTO) {

        SecretResponseDTO secretResponseDTO = secretService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(secretResponseDTO);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SecretResponseDTO> updateSecret(@RequestBody SecretRequestDTO requestDTO, @PathVariable int id) {

        SecretResponseDTO secretResponseDTO = secretService.update(requestDTO, id);
        return ResponseEntity.ok(secretResponseDTO);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<SecretResponseDTO> removeSecret(@PathVariable int id) {

        SecretResponseDTO secretResponseDTO = secretService.delete(id);
        return ResponseEntity.ok(secretResponseDTO);

    }
    
}
