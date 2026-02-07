package com.wykmmm.financeApp.repositories;

import com.wykmmm.financeApp.models.TransactionCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategoryModel, UUID> {
    List<TransactionCategoryModel> findByParentId(UUID parentId);

}