package com.wykmmm.financeApp.services;

import com.wykmmm.financeApp.data.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    public UserDto getUserById(UUID id){
        UserDto user = new UserDto();
        user.setId(id);
        user.setName("Human name");
        user.setEmail("human@mail.com");
        return user;
    }

    public UserDto registerUser(UserDto dto){
        UserDto user = new UserDto();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setId(UUID.randomUUID());
        return user;
    }

    public UserDto updateUser(UserDto dto){
        return dto;
    }

    public void deleteUser(UUID id){
        return;
    }
}
