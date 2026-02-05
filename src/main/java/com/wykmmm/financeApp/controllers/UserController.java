package com.wykmmm.financeApp.controllers;

import com.wykmmm.financeApp.data.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto myUser(@PathVariable UUID id){
        UserDto user = new UserDto();
        user.setId(id);
        user.setName("Human name");
        user.setEmail("human@mail.com");
        return user;
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDto register(@RequestBody UserDto user){
        UserDto registeredUser = new UserDto();
        registeredUser.setEmail(user.getEmail());
        registeredUser.setName(user.getName());
        registeredUser.setId(UUID.randomUUID());
        return registeredUser;
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDto update(@RequestBody UserDto user){
        return user;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        return ResponseEntity.noContent().build();
    }
}
