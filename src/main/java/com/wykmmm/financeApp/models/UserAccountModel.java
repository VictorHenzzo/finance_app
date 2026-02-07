package com.wykmmm.financeApp.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user_account")
public class UserAccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID userId;
    @Column(nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;
    private UUID financialInstitutionId;

    public UserAccountModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public UUID getFinancialInstitutionId() {
        return financialInstitutionId;
    }

    public void setFinancialInstitutionId(UUID financialInstitutionId) {
        this.financialInstitutionId = financialInstitutionId;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAccountModel that = (UserAccountModel) o;
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
