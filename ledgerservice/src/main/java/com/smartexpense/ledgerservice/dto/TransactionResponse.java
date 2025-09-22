package com.smartexpense.ledgerservice.dto;

import com.smartexpense.ledgerservice.entity.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    private Long id;
    private Long userId;
    private Long categoryId;
    private BigDecimal amount;
    private TransactionType transactionType;
    private LocalDateTime transactionDate;
    private String merchant;
    private String note;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
