package com.smartexpense.ledgerservice.repository;

import com.smartexpense.ledgerservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByNameAndIncomeCategory(String name, Boolean incomeCategory);
}
