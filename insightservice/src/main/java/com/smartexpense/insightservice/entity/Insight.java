package com.smartexpense.insightservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "transactions_insight")
public class Insight {
    @Id
    private String id;

    private Long userId;
    private Long transactionId;
    private Long categoryId;
    private BigDecimal amount; // Changed from double to BigDecimal
    private String transactionType;
    private LocalDateTime transactionDate;
    private String merchant;
    private String note;
}

