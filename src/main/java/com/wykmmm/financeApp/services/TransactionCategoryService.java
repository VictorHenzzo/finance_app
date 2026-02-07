package com.wykmmm.financeApp.services;

import com.wykmmm.financeApp.data.dto.TransactionCategoryDto;
import com.wykmmm.financeApp.data.mappers.TransactionCategoryMapper;
import com.wykmmm.financeApp.exceptions.DomainException;
import com.wykmmm.financeApp.exceptions.ResourceNotFound;
import com.wykmmm.financeApp.models.TransactionCategoryModel;
import com.wykmmm.financeApp.repositories.TransactionCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TransactionCategoryService {
    private final TransactionCategoryRepository repository;
    private final TransactionCategoryMapper mapper;
    Logger logger = LoggerFactory.getLogger(TransactionCategoryService.class);


    public TransactionCategoryService(TransactionCategoryRepository repository, TransactionCategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<TransactionCategoryDto> getAll(){
        logger.info("Fetching all categories");
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public TransactionCategoryDto getById(UUID id){
        return mapper.toDto(getByIdOrFail(id));
    }

    public List<TransactionCategoryDto> getAllWithHierarchy(){
        logger.info("Fetching all categories with hierarchy");
        List<TransactionCategoryModel> categories = repository.findAll();

        List<TransactionCategoryDto> roots = new ArrayList<>();
        Map<UUID,List<TransactionCategoryDto>> subcategoriesMap = new HashMap<>();

        for(TransactionCategoryModel model : categories){
            TransactionCategoryDto dto = mapper.toDto(model);
            if(dto.getParentId() == null){
                roots.add(dto);
                continue;
            }

            subcategoriesMap.
                        computeIfAbsent(dto.getParentId(),k -> new ArrayList<>())
                        .add(dto);
        }

        for(TransactionCategoryDto root : roots){
            List<TransactionCategoryDto> children =
                    Optional.ofNullable(subcategoriesMap.get(root.getId()))
                            .orElse(new ArrayList<>());
            root.setSubcategories(children);
        }
        return roots;
    }

    public TransactionCategoryDto create(TransactionCategoryDto input){
        logger.info("Creating new category");
        UUID parentId= input.getParentId();
        if(parentId != null){
            var parent = getByIdOrFail(parentId);

            if (parent.getParentId() != null) {
                throw new
                        DomainException("Cannot nest categories more than 1 level deep."
                );
            }

            if(parent.getType() != input.getType()){
                throw new DomainException("Cannot nest categories with different types");
            }
        }

        TransactionCategoryModel model = mapper.toModel(input);
        model.setId(null);
        TransactionCategoryModel result = repository.save(model);
        return mapper.toDto(result);
    }

    public TransactionCategoryDto update(TransactionCategoryDto input){
        logger.info("Updating category {}", input.getId());
        TransactionCategoryModel model = getByIdOrFail(input.getId());

        if (model.getType() != input.getType()) {
            throw new DomainException("Category type cannot be changed after creation");
        }

        UUID currentParentId = model.getParentId();
        UUID newParentId = input.getParentId();
        boolean hasDependents =
                !repository.findByParentId(model.getId()).isEmpty();

        if(hasDependents && newParentId != null){
            throw new DomainException("Cannot convert this to subcategory because it has dependents");
        }

        if (newParentId != null) {
            var parent = getByIdOrFail(newParentId);

            if (parent.getParentId() != null) {
                throw new DomainException("Cannot mark as subcategory because parent is not a root category");
            }

            if (Objects.equals(model.getId(), newParentId)){
                throw new DomainException("Category cannot be its own parent");
            }

            if (parent.getType() != model.getType()) {
                throw new DomainException("Parent category must have the same type");
            }
        }

        if(!Objects.equals(currentParentId, newParentId)){
            model.setParentId(newParentId);
        }
        if(!Objects.equals(model.getName(), input.getName())){
            model.setName(input.getName());
        }
        if(!Objects.equals(model.getIcon(), input.getIcon())){
            model.setIcon(input.getIcon());
        }
        return mapper.toDto(repository.save(model));
    }

    public void delete(UUID id){
        logger.info("Deleting category {}", id);
        if (!repository.findByParentId(id).isEmpty()) {
            throw new DomainException("Cannot delete category that has subcategories. Please delete subcategories first.");
        }

        var category = getByIdOrFail(id);
        repository.delete(category);
    }

    private TransactionCategoryModel getByIdOrFail(UUID id){
        return repository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Transaction category not found with ID: " + id)
        );
    }
}
