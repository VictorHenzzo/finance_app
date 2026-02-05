package com.wykmmm.financeApp.models;
import java.util.Objects;
import java.util.UUID;
import java.math.BigDecimal;

public class BudgetModel {
    private UUID id;
    private UUID userId;
    private UUID categoryId;
    private BigDecimal amount;
    private Integer year;
    private Integer month;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        BudgetModel that = (BudgetModel) o;
        return Objects.equals(
                getId(),
                that.getId()
        ) && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getCategoryId(),
                                                                             that.getCategoryId()
        ) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getYear(),
                                                                             that.getYear()
        ) && Objects.equals(
                getMonth(),
                that.getMonth()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getUserId(),
                getCategoryId(),
                getAmount(),
                getYear(),
                getMonth()
        );
    }
}