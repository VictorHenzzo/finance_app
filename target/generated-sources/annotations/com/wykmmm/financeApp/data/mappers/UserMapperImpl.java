package com.wykmmm.financeApp.data.mappers;

import com.wykmmm.financeApp.data.dto.UserDto;
import com.wykmmm.financeApp.models.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-07T14:17:50-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(UserModel model) {
        if ( model == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( model.getId() );
        userDto.setEmail( model.getEmail() );
        userDto.setName( model.getName() );

        return userDto;
    }

    @Override
    public UserModel toModel(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setEmail( dto.getEmail() );
        userModel.setName( dto.getName() );

        return userModel;
    }
}
