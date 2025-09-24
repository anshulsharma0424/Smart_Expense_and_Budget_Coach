package com.smartexpense.insightservice.repository;

import com.smartexpense.insightservice.entity.Insight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsightRepository extends MongoRepository<Insight, String> {
    // Custom queries
    List<Insight> findByUserId(Long userId);
    List<Insight> findByUserIdAndTransactionType(Long userId, String transactionType);
    List<Insight> findByUserIdAndCategoryId(Long userId, Long categoryId);
}
