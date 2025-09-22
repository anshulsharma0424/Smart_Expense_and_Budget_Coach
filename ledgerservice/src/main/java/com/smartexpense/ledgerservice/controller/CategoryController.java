package com.smartexpense.ledgerservice.controller;

import com.smartexpense.ledgerservice.dto.CategoryRequest;
import com.smartexpense.ledgerservice.dto.CategoryResponse;
import com.smartexpense.ledgerservice.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ledger/categories")
public class CategoryController {

    private final CategoryService categoryService;

    // Constructor injection of CategoryService
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // add new category
    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok(categoryService.addCategory(categoryRequest));
    }

    // list all categories
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
