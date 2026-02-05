package com.wykmmm.financeApp.services;

import com.wykmmm.financeApp.data.dto.UserDto;
import com.wykmmm.financeApp.exceptions.userExceptions.EmailAlreadyInUseException;
import com.wykmmm.financeApp.exceptions.userExceptions.UserNotFoundException;
import com.wykmmm.financeApp.models.UserModel;
import com.wykmmm.financeApp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDto getUserById(UUID id){
        return mapUserToDto(getUser(id));
    }

    public UserDto registerUser(UserDto dto){
        if(repository.existsByEmail(dto.getEmail())){
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

        if(!Objects.equals(dto.getEmail(), user.getEmail())){
            user.setEmail(dto.getEmail());
        }
        if(!Objects.equals(dto.getName(), user.getName())){
            user.setName(dto.getName());
        }
        return mapUserToDto(repository.save(user));
    }

    public void deleteUser(UUID id){
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
