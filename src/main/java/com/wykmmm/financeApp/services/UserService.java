package com.wykmmm.financeApp.services;

import com.wykmmm.financeApp.data.dto.UserDto;
import com.wykmmm.financeApp.exceptions.userExceptions.EmailAlreadyInUseException;
import com.wykmmm.financeApp.exceptions.userExceptions.UserNotFoundException;
import com.wykmmm.financeApp.models.UserModel;
import com.wykmmm.financeApp.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDto getUserById(UUID id) {
        logger.info("Getting user by id: {}", id);
        return mapUserToDto(getUser(id));
    }

    public UserDto registerUser(UserDto dto){
        logger.info("Registering new user");
        if(repository.existsByEmail(dto.getEmail())){
            logger.info("Attempted to register user with existing email");
            throw new EmailAlreadyInUseException("Email already in use");
        }

        UserModel user = new UserModel();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        UserModel result = repository.save(user);
        return mapUserToDto(result);
    }

    public UserDto updateUser(UserDto dto){
        UserModel user = getUser( dto.getId());
        String newName = dto.getName();
        String newEmail = dto.getEmail();

        if(newEmail != null && !Objects.equals(newEmail, user.getEmail())){
            user.setEmail(dto.getEmail());
        }
        if(newName != null && !Objects.equals(newName, user.getName())){
            user.setName(dto.getName());
        }
        logger.info("Updating user");
        return mapUserToDto(repository.save(user));
    }

    public void deleteUser(UUID id){
        logger.info("Deleting user: {}", id);
        UserModel user = getUser(id);
        repository.delete(user);
    }

    private UserModel getUser(UUID id){
      return  repository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("User not found with ID: " + id)
        );
    }

    private UserDto mapUserToDto(UserModel model){
        UserDto dto =new UserDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setEmail(model.getEmail());
        return dto;
    }
}
