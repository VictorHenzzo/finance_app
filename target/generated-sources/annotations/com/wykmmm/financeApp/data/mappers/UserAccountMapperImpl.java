package com.wykmmm.financeApp.data.mappers;

import com.wykmmm.financeApp.data.dto.UserAccountDto;
import com.wykmmm.financeApp.models.UserAccountModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-07T14:17:49-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class UserAccountMapperImpl implements UserAccountMapper {

    @Override
    public UserAccountDto toDto(UserAccountModel model) {
        if ( model == null ) {
            return null;
        }

        UserAccountDto userAccountDto = new UserAccountDto();

        userAccountDto.setId( model.getId() );
        userAccountDto.setUserId( model.getUserId() );
        userAccountDto.setBalance( model.getBalance() );
        userAccountDto.setFinancialInstitutionId( model.getFinancialInstitutionId() );

        return userAccountDto;
    }

    @Override
    public UserAccountModel toModel(UserAccountDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserAccountModel userAccountModel = new UserAccountModel();

        userAccountModel.setUserId( dto.getUserId() );
        userAccountModel.setBalance( dto.getBalance() );
        userAccountModel.setFinancialInstitutionId( dto.getFinancialInstitutionId() );

        return userAccountModel;
    }
}
