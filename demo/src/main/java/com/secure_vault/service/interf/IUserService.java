package com.secure_vault.service.interf;

import java.util.List;

import com.secure_vault.dto.UserRequestDTO;
import com.secure_vault.dto.UserResponseDTO;
import com.secure_vault.exceptions.UserValidationException;

public interface IUserService {
    
    UserResponseDTO create(UserRequestDTO userToCreate) throws UserValidationException;

    List<UserResponseDTO> getAll();

    UserResponseDTO update(UserRequestDTO userToUpdate, int idUserToUpdate) throws UserValidationException;

    UserResponseDTO delete(int idUserToDelete) throws UserValidationException;

}
