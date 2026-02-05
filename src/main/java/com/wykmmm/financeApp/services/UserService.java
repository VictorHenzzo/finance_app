package com.wykmmm.financeApp.services;

import com.wykmmm.financeApp.data.dto.UserDto;
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
        UserModel user = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("User not found with ID: " + id)
        );

        return mapUserToDto(user);
    }

    public UserDto registerUser(UserDto dto){
        UserModel user = new UserModel();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        UserModel result = repository.save(user);
        return mapUserToDto(result);
    }

    public UserDto updateUser(UserDto dto){
        UUID id = dto.getId();
        UserModel user = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("User not found with ID: " + id)
        );

        if(!Objects.equals(dto.getEmail(), user.getEmail())){
            user.setEmail(dto.getEmail());
        }
        if(!Objects.equals(dto.getName(), user.getName())){
            user.setName(dto.getName());
        }
        return mapUserToDto(repository.save(user));
    }

    public void deleteUser(UUID id){
        UserModel user = repository.findById(id).orElseThrow(
                ()-> new RuntimeException("User not found with ID: " + id)
        );
        repository.delete(user);
    }

    private UserDto mapUserToDto(UserModel model){
        UserDto dto =new UserDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setEmail(model.getEmail());
        return dto;
    }
}
