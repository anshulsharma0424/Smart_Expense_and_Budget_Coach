package com.smartexpense.ledgerservice.mapper;

import com.smartexpense.ledgerservice.dto.CategoryRequest;
import com.smartexpense.ledgerservice.dto.CategoryResponse;
import com.smartexpense.ledgerservice.entity.Category;

public class CategoryMapper {

    public static Category toCategoryEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setIncomeCategory(request.getIncomeCategory());

        return category;
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        response.setIncomeCategory(category.getIncomeCategory());

        return response;
    }
}
