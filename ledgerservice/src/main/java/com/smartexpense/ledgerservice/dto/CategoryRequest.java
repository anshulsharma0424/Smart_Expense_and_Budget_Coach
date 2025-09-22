package com.smartexpense.ledgerservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryRequest {
    @NotNull(message = "Category name cannot be null")
    @Size(max = 100)
    private String name;

    // true for Income category, false for Expense category
    @NotNull(message = "Please write 'true' for Income category or 'false' for Expense category")
    private Boolean incomeCategory;
}
