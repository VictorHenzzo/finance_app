package com.wykmmm.financeApp.data.mappers;

import com.wykmmm.financeApp.data.dto.FinancialInstitutionDto;
import com.wykmmm.financeApp.models.FinancialInstitutionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FinancialInstitutionMapper {
    FinancialInstitutionDto toDto(FinancialInstitutionModel model);
    @Mapping(target = "id", ignore = true)
    FinancialInstitutionModel toModel(FinancialInstitutionDto dto);
}
