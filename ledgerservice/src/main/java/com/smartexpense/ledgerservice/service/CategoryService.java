package com.smartexpense.ledgerservice.service;

import com.smartexpense.ledgerservice.dto.CategoryRequest;
import com.smartexpense.ledgerservice.dto.CategoryResponse;
import com.smartexpense.ledgerservice.entity.Category;
import com.smartexpense.ledgerservice.exception.CategoryAlreadyExistsException;
import com.smartexpense.ledgerservice.mapper.CategoryMapper;
import com.smartexpense.ledgerservice.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse addCategory(@Valid CategoryRequest categoryRequest) {
        if (categoryRepository.existsByNameAndIncomeCategory(categoryRequest.getName(), categoryRequest.getIncomeCategory())) {
            throw new CategoryAlreadyExistsException("Category with name: " + categoryRequest.getName() +
                    " and incomeCategory: " + categoryRequest.getIncomeCategory() + " already exists.");
        }

        Category category = CategoryMapper.toCategoryEntity(categoryRequest);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toCategoryResponse(savedCategory);
    }

    public List<CategoryResponse> getAllCategories() {
        List<Category>  categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::toCategoryResponse)
                .collect(Collectors.toList());

    }
}
