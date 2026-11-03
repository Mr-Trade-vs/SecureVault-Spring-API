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

import com.secure_vault.dto.UserRequestDTO;
import com.secure_vault.dto.UserResponseDTO;
import com.secure_vault.service.interf.IUserService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping("/users")
@RequiredArgsConstructor 
public class UserController {

    private final IUserService userService;

    @GetMapping 
    public ResponseEntity<List<UserResponseDTO>> getAll() {

        List<UserResponseDTO> users = userService.getAll();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO requestDTO) {

        UserResponseDTO userResponseDTO = userService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserRequestDTO requestDTO, @PathVariable int id) {

        UserResponseDTO userResponseDTO = userService.update(requestDTO, id);
        return ResponseEntity.ok(userResponseDTO);

    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<UserResponseDTO> removeUser(@PathVariable int id ) {

        UserResponseDTO userResponseDTO = userService.delete(id);
        return ResponseEntity.ok(userResponseDTO);

    }
    
}
