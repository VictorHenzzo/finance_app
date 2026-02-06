package com.wykmmm.financeApp.services;

import com.wykmmm.financeApp.data.dto.UserDto;
import com.wykmmm.financeApp.data.mappers.UserMapper;
import com.wykmmm.financeApp.exceptions.DomainException;
import com.wykmmm.financeApp.exceptions.ResourceNotFound;
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
    private final UserMapper mapper;
    Logger logger = LoggerFactory.getLogger(UserService.class);


    public UserService(UserRepository repository,UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDto getUserById(UUID id) {
        logger.info("Getting user by id: {}", id);
        return mapper.toDto(getUser(id));
    }

    public UserDto registerUser(UserDto dto){
        logger.info("Registering new user");
        if(repository.existsByEmail(dto.getEmail())){
            logger.info("Attempted to register user with existing email");
            throw new DomainException("Email already in use");
        }

        UserModel user = mapper.toModel(dto);
        UserModel result = repository.save(user);
        return mapper.toDto(result);
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
        return mapper.toDto(repository.save(user));
    }

    public void deleteUser(UUID id){
        logger.info("Deleting user: {}", id);
        UserModel user = getUser(id);
        repository.delete(user);
    }

    private UserModel getUser(UUID id){
      return  repository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("User not found with ID: " + id)
        );
    }
}
