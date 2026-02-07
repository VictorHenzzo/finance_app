package com.wykmmm.financeApp.models;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "transaction_category")
public class TransactionCategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID parentId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String icon;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "category_type")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
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
        TransactionCategoryModel that = (TransactionCategoryModel) o;
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