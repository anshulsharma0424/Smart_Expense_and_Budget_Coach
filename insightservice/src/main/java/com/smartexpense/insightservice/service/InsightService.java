package com.smartexpense.insightservice.service;

import com.smartexpense.insightservice.entity.Insight;
import com.smartexpense.insightservice.repository.InsightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsightService {
    private final InsightRepository insightRepository;

    public InsightService(InsightRepository insightRepository) {
        this.insightRepository = insightRepository;
    }

    // Save new transaction insight (Kafka se aayega ya manually bhi test kar sakte ho)
    public Insight saveTransactionInsight(Insight insight) {
        return insightRepository.save(insight);
    }

    // Get all insights of a user
    public List<Insight> getInsightsByUser(Long userId) {
        return insightRepository.findByUserId(userId);
    }

    // Filter by transaction type (INCOME / EXPENSE)
    public List<Insight> getInsightsByUserAndType(Long userId, String type) {
        return insightRepository.findByUserIdAndTransactionType(userId, type);
    }

    // Filter by category
    public List<Insight> getInsightsByUserAndCategory(Long userId, Long categoryId) {
        return insightRepository.findByUserIdAndCategoryId(userId, categoryId);
    }
}
