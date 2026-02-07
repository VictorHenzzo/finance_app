package com.wykmmm.financeApp.data.mappers;

import com.wykmmm.financeApp.data.dto.TransactionCategoryDto;
import com.wykmmm.financeApp.models.TransactionCategoryModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-02-07T17:57:57-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Oracle Corporation)"
)
@Component
public class TransactionCategoryMapperImpl implements TransactionCategoryMapper {

    @Override
    public TransactionCategoryDto toDto(TransactionCategoryModel model) {
        if ( model == null ) {
            return null;
        }

        TransactionCategoryDto transactionCategoryDto = new TransactionCategoryDto();

        transactionCategoryDto.setId( model.getId() );
        transactionCategoryDto.setParentId( model.getParentId() );
        transactionCategoryDto.setName( model.getName() );
        transactionCategoryDto.setIcon( model.getIcon() );
        transactionCategoryDto.setType( model.getType() );

        return transactionCategoryDto;
    }

    @Override
    public TransactionCategoryModel toModel(TransactionCategoryDto dto) {
        if ( dto == null ) {
            return null;
        }

        TransactionCategoryModel transactionCategoryModel = new TransactionCategoryModel();

        transactionCategoryModel.setParentId( dto.getParentId() );
        transactionCategoryModel.setName( dto.getName() );
        transactionCategoryModel.setIcon( dto.getIcon() );
        transactionCategoryModel.setType( dto.getType() );

        return transactionCategoryModel;
    }
}
