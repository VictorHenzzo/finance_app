package com.wykmmm.financeApp.models;
import java.util.Objects;
import java.util.UUID;

public class TransactionCategory {
    private UUID id;
    private UUID parentId;
    private String name;
    private String icon;
    private CategoryType type;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionCategory that = (TransactionCategory) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getParentId(),
                                                                       that.getParentId()
        ) && Objects.equals(
                getName(),
                that.getName()
        ) && Objects.equals(
                getIcon(),
                that.getIcon()
        ) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getParentId(),
                getName(),
                getIcon(),
                getType()
        );
    }

    public enum CategoryType {
        INCOME,
        EXPENSE
    }
}