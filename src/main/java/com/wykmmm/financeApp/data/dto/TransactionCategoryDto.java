package com.wykmmm.financeApp.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import static com.wykmmm.financeApp.models.TransactionCategoryModel.*;

public class TransactionCategoryDto {
    public TransactionCategoryDto() {
        subcategories = new ArrayList<>();
    }

    private UUID id;
    private UUID parentId;
    private String name;
    private String icon;
    private CategoryType type;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TransactionCategoryDto> subcategories;

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

    public List<TransactionCategoryDto> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<TransactionCategoryDto> subcategories) {
        this.subcategories = subcategories;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionCategoryDto that = (TransactionCategoryDto) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getParentId(),
                                                                       that.getParentId()
        ) && Objects.equals(
                getName(),
                that.getName()
        ) && Objects.equals(
                getIcon(),
                that.getIcon()
        ) && getType() == that.getType() && Objects.equals(
                getSubcategories(),
                that.getSubcategories()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getParentId(),
                getName(),
                getIcon(),
                getType(),
                getSubcategories()
        );
    }
}
