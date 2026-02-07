package com.wykmmm.financeApp.services;

import com.wykmmm.financeApp.data.dto.UserAccountDto;
import com.wykmmm.financeApp.data.mappers.UserAccountMapper;
import com.wykmmm.financeApp.exceptions.ResourceNotFound;
import com.wykmmm.financeApp.models.UserAccountModel;
import com.wykmmm.financeApp.repositories.UserAccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserAccountService {
    private final UserAccountRepository repository;
    private final UserAccountMapper mapper;
    Logger logger = LoggerFactory.getLogger(UserAccountService.class);

    public UserAccountService(UserAccountRepository repository,UserAccountMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UserAccountDto> getUserAccounts(UUID userId) {
        logger.info("Getting user {} accounts", userId);
        return repository.findAllByUserId(userId).stream().map(mapper::toDto).toList();
    }

    public UserAccountDto register(UserAccountDto dto){
        logger.info("Creating user account");
        UserAccountModel newAccount = new UserAccountModel();
        newAccount.setUserId(dto.getUserId());
        newAccount.setFinancialInstitutionId(dto.getFinancialInstitutionId());
        UserAccountModel result = repository.save(newAccount);
        return mapper.toDto(result);
    }

    public UserAccountDto update(UserAccountDto dto){
        logger.info("Updating user account {}",dto.getId());
        UserAccountModel account = getByIdOrFail(dto.getId());

        if(!Objects.equals(
                dto.getFinancialInstitutionId(),
                account.getFinancialInstitutionId()
        )){
            account.setFinancialInstitutionId(dto.getFinancialInstitutionId());
        }

        return mapper.toDto(repository.save(account));
    }

    public void delete(UUID accountId){
        logger.info("Deleting user account {}",accountId);
        repository.delete(getByIdOrFail(accountId));
    }

    private UserAccountModel getByIdOrFail(UUID accountId){
        return repository.findById(accountId).orElseThrow(
                ()-> new ResourceNotFound("User account with id " + accountId + "not found")
        );
    }
}
