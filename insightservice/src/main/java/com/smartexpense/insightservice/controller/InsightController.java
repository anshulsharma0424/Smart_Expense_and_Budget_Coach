package com.smartexpense.insightservice.controller;

import com.smartexpense.insightservice.entity.Insight;
import com.smartexpense.insightservice.service.InsightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insights")
public class InsightController {
    private final InsightService insightService;

    public InsightController(InsightService insightService) {
        this.insightService = insightService;
    }

    // Save new insight
    @PostMapping
    public ResponseEntity<Insight> saveInsight(@RequestBody Insight insight) {
        return ResponseEntity.ok(insightService.saveTransactionInsight(insight));
    }

    // Get all insights of a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Insight>> getInsightsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(insightService.getInsightsByUser(userId));
    }

    // Get insights by transaction type (INCOME/EXPENSE)
    @GetMapping("/user/{userId}/type/{type}")
    public ResponseEntity<List<Insight>> getInsightsByType(
            @PathVariable Long userId,
            @PathVariable String type) {
        return ResponseEntity.ok(insightService.getInsightsByUserAndType(userId, type));
    }

    // Get insights by category
    @GetMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<List<Insight>> getInsightsByCategory(
            @PathVariable Long userId,
            @PathVariable Long categoryId) {
        return ResponseEntity.ok(insightService.getInsightsByUserAndCategory(userId, categoryId));
    }
}
