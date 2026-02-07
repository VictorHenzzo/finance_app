package com.wykmmm.financeApp.controllers;

import com.wykmmm.financeApp.data.dto.FinancialInstitutionDto;
import com.wykmmm.financeApp.services.FinancialInstitutionService;
import com.wykmmm.financeApp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("financial-institution")
public class FinancialInstitutionController {

    private final FinancialInstitutionService service;

    public FinancialInstitutionController(FinancialInstitutionService service) {this.service = service;}

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FinancialInstitutionDto> getAll(){
        return service.getAll();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public FinancialInstitutionDto getById(@PathVariable UUID id){
        return service.getById(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public FinancialInstitutionDto register(@RequestBody FinancialInstitutionDto dto){
        return service.register(dto);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public FinancialInstitutionDto update(@RequestBody FinancialInstitutionDto dto){
        return service.update(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
