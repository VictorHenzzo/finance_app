package com.wykmmm.financeApp.controllers;

import com.wykmmm.financeApp.data.dto.UserAccountDto;
import com.wykmmm.financeApp.services.UserAccountService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user-account")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {this.service = service;}

    @GetMapping(value = "/my-accounts/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserAccountDto> getUserAccounts(@PathVariable UUID id){
        return service.getUserAccounts(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public UserAccountDto register(@RequestBody UserAccountDto dto){
        return service.register(dto);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public UserAccountDto update(@RequestBody UserAccountDto dto){
        return service.update(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
