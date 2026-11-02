package com.secure_vault.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.secure_vault.exceptions.UserValidationException;
import com.secure_vault.model.User;
import com.secure_vault.repository.IUserRepository;
import com.secure_vault.service.interf.IUserService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public void create(User userToCreate) throws UserValidationException {
        
        checkInfo(userToCreate);

        userRepository.save(userToCreate);

        
    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll();

    }

    @Override
    public void update(User userToUpdate) throws UserValidationException {
        
        checkInfo(userToUpdate);

        findUser(userToUpdate.getId());

        userRepository.save(userToUpdate);

    }

    @Override
    public void delete(User userToDelete) throws UserValidationException {
        
        checkInfo(userToDelete);

        findUser(userToDelete.getId());

        userRepository.delete(userToDelete);

    }

    private void checkInfo(User user) throws UserValidationException {

        if (user == null) throw new UserValidationException("User is empty, info wasn't provided");

        //More business logic if is needed

    }

    @Override
    public User findUser(int idUser) throws UserValidationException {
        
        if (idUser < 0) throw new UserValidationException("Id have an invalid format, chcek again");
        
        Optional<User> userSearch = userRepository.findById(idUser);

        return userSearch.orElseThrow(() -> new UserValidationException("User is empty, info wasn't provided"));
        
    }

}
