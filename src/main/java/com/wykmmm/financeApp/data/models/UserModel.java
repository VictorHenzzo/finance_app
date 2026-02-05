package com.wykmmm.financeApp.data.models;

import java.util.Objects;
import java.util.UUID;

public class UserModel {
    private UUID id;
    private String email;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        UserModel userModel = (UserModel) o;
        return Objects.equals(getId(), userModel.getId()) && Objects.equals(getEmail(),
                                                                            userModel.getEmail()
        ) && Objects.equals(
                getName(),
                userModel.getName()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getName());
    }
}
