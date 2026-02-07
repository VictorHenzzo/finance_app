package com.wykmmm.financeApp.data.mappers;

import com.wykmmm.financeApp.data.dto.TransactionCategoryDto;
import com.wykmmm.financeApp.models.TransactionCategoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionCategoryMapper {
    TransactionCategoryDto toDto(TransactionCategoryModel model);
    @Mapping(target = "id", ignore = true)
    TransactionCategoryModel toModel(TransactionCategoryDto dto);
}
