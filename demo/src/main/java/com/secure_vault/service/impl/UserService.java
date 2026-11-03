package com.secure_vault.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.secure_vault.dto.UserRequestDTO;
import com.secure_vault.dto.UserResponseDTO;
import com.secure_vault.exceptions.UserValidationException;
import com.secure_vault.mappers.IUserMapper;
import com.secure_vault.model.User;
import com.secure_vault.repository.IUserRepository;
import com.secure_vault.service.interf.IUserService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IUserMapper userMapper;

    @Override
    public UserResponseDTO create(UserRequestDTO userToCreate) throws UserValidationException {
        
        checkInfo(userToCreate);

        User userDB = userMapper.toEntity(userToCreate);
        userDB = idGeneration(userDB);

        userRepository.save(userDB);

        return userMapper.toResponse(userDB);

    }

    @Override
    public List<UserResponseDTO> getAll() {

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) return new ArrayList<UserResponseDTO>();

        List<UserResponseDTO> userConversion = new ArrayList<UserResponseDTO>();
        for (User user : users) 
            userConversion.add(userMapper.toResponse(user));

        return userConversion;

    }

    @Override
    public UserResponseDTO update(UserRequestDTO userToUpdate, int idUserToUpdate) throws UserValidationException {
        
        checkInfo(userToUpdate);
        
        findUser(idUserToUpdate);

        User userDB = userMapper.toEntity(userToUpdate);
        userDB.setId(idUserToUpdate);

        userRepository.save(userDB);

        return userMapper.toResponse(userDB);

    }

    @Override
    public UserResponseDTO delete(int idUserToDelete) throws UserValidationException {

        User userRemove = findUser(idUserToDelete);

        userRepository.delete(userRemove);

        return userMapper.toResponse(userRemove);

    }

    private void checkInfo(UserRequestDTO user) throws UserValidationException {

        if (user == null) throw new UserValidationException("User is empty, info wasn't provided");

        //More business logic if is needed

    }

    private User findUser(int idUser) throws UserValidationException {
        
        if (idUser < 0) throw new UserValidationException("Id have an invalid format, chcek again");
        
        Optional<User> userSearch = userRepository.findById(idUser);

        return userSearch.orElseThrow(() -> new UserValidationException("User is empty, info wasn't provided"));
        
    }

    private User idGeneration (User user) {

        Optional<User> lastUser = userRepository.findFirstByOrderByIdDesc();

        if (lastUser.isEmpty()) user.setId(1);
        else user.setId(lastUser.get().getId() + 1); 

        return user;

    }

}
