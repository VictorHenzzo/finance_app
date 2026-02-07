package com.wykmmm.financeApp.data.mappers;

import com.wykmmm.financeApp.data.dto.UserAccountDto;
import com.wykmmm.financeApp.models.UserAccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
    UserAccountDto toDto(UserAccountModel model);
    @Mapping(target = "id", ignore = true)
    UserAccountModel toModel(UserAccountDto dto);
}
