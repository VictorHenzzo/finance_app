package com.wykmmm.financeApp.repositories;

import com.wykmmm.financeApp.models.FinancialInstitutionModel;
import com.wykmmm.financeApp.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FinancialInstitutionRepository extends JpaRepository<FinancialInstitutionModel, UUID> {
}
