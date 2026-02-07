package com.wykmmm.financeApp.services;

import com.wykmmm.financeApp.data.dto.FinancialInstitutionDto;
import com.wykmmm.financeApp.data.mappers.FinancialInstitutionMapper;
import com.wykmmm.financeApp.exceptions.ResourceNotFound;
import com.wykmmm.financeApp.models.FinancialInstitutionModel;
import com.wykmmm.financeApp.repositories.FinancialInstitutionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FinancialInstitutionService {
    private final FinancialInstitutionRepository repository;
    private final FinancialInstitutionMapper mapper;
    Logger logger = LoggerFactory.getLogger(FinancialInstitutionService.class);

    public FinancialInstitutionService(FinancialInstitutionRepository repository,FinancialInstitutionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public FinancialInstitutionDto getById(UUID id) {
        logger.info("Getting institution by id: {}", id);
        return mapper.toDto(getInstitution(id));
    }

    public List<FinancialInstitutionDto> getAll() {
        logger.info("Getting all institutions");

        return repository.findAll().stream()
                            .map(mapper::toDto)
                            .toList();

    }

    public FinancialInstitutionDto register(FinancialInstitutionDto dto){
        logger.info("Registering new institution");
        FinancialInstitutionModel model = mapper.toModel(dto);
        return mapper.toDto(repository.save(model));
    }

    public FinancialInstitutionDto update(FinancialInstitutionDto dto){
        FinancialInstitutionModel institution = getInstitution(dto.getId());
        String newName = dto.getName();
        String newIconUrl = dto.getIconUrl();

        if(newIconUrl != null && !Objects.equals(newIconUrl, institution.getIconUrl())){
            institution.setIconUrl(dto.getIconUrl());
        }
        if(newName != null && !Objects.equals(newName, institution.getName())){
            institution.setName(dto.getName());
        }
        logger.info("Updating institution");
        return mapper.toDto(repository.save(institution));
    }

    public void delete(UUID id){
        logger.info("Deleting institution: {}", id);
        FinancialInstitutionModel institution = getInstitution(id);
        repository.delete(institution);
    }

    private FinancialInstitutionModel getInstitution(UUID id){
        return  repository.findById(id).orElseThrow(
                ()-> new ResourceNotFound("Financial institution not found with ID: " + id)
        );
    }
}