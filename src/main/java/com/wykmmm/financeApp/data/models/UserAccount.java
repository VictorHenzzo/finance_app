package com.wykmmm.financeApp.data.models;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class UserAccount {
    private UUID id;
    private String userId;
    private BigDecimal balance;
    private String financialInstitutionId;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getFinancialInstitutionId() {
        return financialInstitutionId;
    }

    public void setFinancialInstitutionId(String financialInstitutionId) {
        this.financialInstitutionId = financialInstitutionId;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAccount that = (UserAccount) o;
        return Objects.equals(
                getId(),
                that.getId()
        ) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getBalance(),
                                                                             that.getBalance()
        ) && Objects.equals(
                getFinancialInstitutionId(),
                that.getFinancialInstitutionId()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getUserId(),
                getBalance(),
                getFinancialInstitutionId()
        );
    }
}
