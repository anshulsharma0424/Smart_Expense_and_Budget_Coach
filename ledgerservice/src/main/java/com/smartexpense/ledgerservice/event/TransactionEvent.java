package com.smartexpense.ledgerservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEvent {
    private Long transactionId;
    private Long categoryId;
    private Long userId;
    private BigDecimal amount;
    private String transactionType;
    private String merchant;
    private String note;
    private LocalDateTime transactionDate;
}
