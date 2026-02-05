package com.wykmmm.financeApp.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class TransactionModel {
    private UUID id;
    private UUID sourceAccountId;
    private UUID targetAccountId;
    private UUID categoryId;
    private BigDecimal amount;
    private String description;
    private Date date;
    private TransactionType type;

    public enum TransactionType {
        INCOME,
        EXPENSE,
        TRANSFER
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(UUID sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public UUID getTargetAccountId() {
        return targetAccountId;
    }

    public void setTargetAccountId(UUID targetAccountId) {
        this.targetAccountId = targetAccountId;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionModel that = (TransactionModel) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(
                getSourceAccountId(),
                that.getSourceAccountId()
        ) && Objects.equals(
                getTargetAccountId(),
                that.getTargetAccountId()
        ) && Objects.equals(
                getCategoryId(),
                that.getCategoryId()
        ) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getDescription(),
                                                                             that.getDescription()
        ) && Objects.equals(
                getDate(),
                that.getDate()
        ) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getSourceAccountId(),
                getTargetAccountId(),
                getCategoryId(),
                getAmount(),
                getDescription(),
                getDate(),
                getType()
        );
    }


}
