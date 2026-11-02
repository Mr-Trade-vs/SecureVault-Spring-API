package com.secure_vault.service.interf;

import java.util.List;

import com.secure_vault.exceptions.UserValidationException;
import com.secure_vault.model.User;

public interface IUserService {
    
    void create(User userToCreate) throws UserValidationException;

    List<User> getAll();

    void update(User userToUpdate) throws UserValidationException;

    void delete(User userToDelete) throws UserValidationException;

    User findUser(int idUser) throws UserValidationException;

}
