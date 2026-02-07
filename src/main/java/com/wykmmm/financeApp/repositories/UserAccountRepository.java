package com.wykmmm.financeApp.repositories;

import com.wykmmm.financeApp.models.UserAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserAccountRepository extends JpaRepository<UserAccountModel, UUID> {
    List<UserAccountModel> findAllByUserId(UUID userId);
}


