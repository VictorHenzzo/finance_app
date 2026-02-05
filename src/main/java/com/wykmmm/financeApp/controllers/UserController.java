package com.wykmmm.financeApp.controllers;

import com.wykmmm.financeApp.data.dto.UserDto;
import com.wykmmm.financeApp.models.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("/me/{id}")
    public UserDto myUser(@PathVariable UUID id){
        UserDto user = new UserDto();
        user.setId(id);
        user.setName("Human name");
        user.setEmail("human@mail.com");
        return user;
    }
}
