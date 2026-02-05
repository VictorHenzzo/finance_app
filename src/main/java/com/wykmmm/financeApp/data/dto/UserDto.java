package com.wykmmm.financeApp.data.dto;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class UserDto {
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
        UserDto userDto = (UserDto) o;
        return Objects.equals(getId(), userDto.getId()) && Objects.equals(getEmail(),
                                                                          userDto.getEmail()
        ) && Objects.equals(
                getName(),
                userDto.getName()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getName());
    }
}
