package com.wykmmm.financeApp.data.mappers;

import com.wykmmm.financeApp.data.dto.UserDto;
import com.wykmmm.financeApp.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(UserModel model);
    @Mapping(target = "id", ignore = true)
    UserModel toModel(UserDto dto);
}
