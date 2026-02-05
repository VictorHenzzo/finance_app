package com.wykmmm.financeApp.models;
import java.util.UUID;
import java.util.Objects;

public class FinancialInstitution {
    private UUID id;
    private String name;
    private String iconUrl;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        FinancialInstitution that = (FinancialInstitution) o;
        return Objects.equals(
                getId(),
                that.getId()
        ) && Objects.equals(getName(), that.getName()) && Objects.equals(
                getIconUrl(),
                that.getIconUrl()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getIconUrl());
    }
}
