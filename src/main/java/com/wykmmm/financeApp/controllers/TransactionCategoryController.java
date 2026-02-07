package com.wykmmm.financeApp.controllers;

import com.wykmmm.financeApp.data.dto.TransactionCategoryDto;
import com.wykmmm.financeApp.services.TransactionCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("transaction-category")
public class TransactionCategoryController {

    private final TransactionCategoryService service;

    public TransactionCategoryController(TransactionCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransactionCategoryDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/hierarchy")
    public List<TransactionCategoryDto> getAllWithHierarchy() {
        return service.getAllWithHierarchy();
    }

    @GetMapping("/{id}")
    public TransactionCategoryDto getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionCategoryDto create(@RequestBody TransactionCategoryDto input) {
        return service.create(input);
    }

    @PutMapping("/{id}")
    public TransactionCategoryDto update(
            @PathVariable UUID id,
            @RequestBody TransactionCategoryDto input
    ) {
        input.setId(id);
        return service.update(input);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
