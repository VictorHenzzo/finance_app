package com.wykmmm.financeApp.data.mappers;

import com.wykmmm.financeApp.data.dto.FinancialInstitutionDto;
import com.wykmmm.financeApp.models.FinancialInstitutionModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-07T14:17:50-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class FinancialInstitutionMapperImpl implements FinancialInstitutionMapper {

    @Override
    public FinancialInstitutionDto toDto(FinancialInstitutionModel model) {
        if ( model == null ) {
            return null;
        }

        FinancialInstitutionDto financialInstitutionDto = new FinancialInstitutionDto();

        financialInstitutionDto.setId( model.getId() );
        financialInstitutionDto.setName( model.getName() );
        financialInstitutionDto.setIconUrl( model.getIconUrl() );

        return financialInstitutionDto;
    }

    @Override
    public FinancialInstitutionModel toModel(FinancialInstitutionDto dto) {
        if ( dto == null ) {
            return null;
        }

        FinancialInstitutionModel financialInstitutionModel = new FinancialInstitutionModel();

        financialInstitutionModel.setName( dto.getName() );
        financialInstitutionModel.setIconUrl( dto.getIconUrl() );

        return financialInstitutionModel;
    }
}
