//package com.smartexpense.ledgerservice.dto;
//
//import com.smartexpense.ledgerservice.entity.TransactionType;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
//import jakarta.validation.constraints.DecimalMin;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Data
//public class TransactionRequest {
//
//    // Foreign Key to users table
//    @NotNull(message = "UserID is required")
//    private Long userId;
//
//    // Foreign Key to category table
//    @NotNull(message = "CategoryID is required")
//    private Long categoryId;
//
//    @NotNull(message = "Amount cannot be null")
//    @DecimalMin(value = "0.01", message = "Amount must be positive")
//    private BigDecimal amount;
//
//    @NotNull(message = "Transaction type is required")
//    @Enumerated(EnumType.STRING)
//    private TransactionType transactionType;
//
//    @NotNull(message = "Transaction date is required")
//    private LocalDateTime transactionDate;
//
//    @Size(max = 100)
//    private String merchant;
//
//    @Size(max = 255)
//    private String note;
//}
