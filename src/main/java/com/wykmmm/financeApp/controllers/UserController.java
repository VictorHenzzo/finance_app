package com.wykmmm.financeApp.controllers;

import com.wykmmm.financeApp.data.dto.UserDto;
import com.wykmmm.financeApp.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {this.service = service;}

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto myUser(@PathVariable UUID id){
        return service.getUserById(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDto register(@RequestBody UserDto user){
        return service.registerUser(user);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDto update(@RequestBody UserDto user){
        return service.updateUser(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
