package com.smartexpense.ledgerservice.dto;
import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private Boolean incomeCategory;
}
