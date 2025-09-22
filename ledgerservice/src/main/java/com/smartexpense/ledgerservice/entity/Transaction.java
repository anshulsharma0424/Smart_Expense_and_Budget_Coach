//package com.smartexpense.ledgerservice.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.*;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter @Setter
//@Builder
//@Table(name = "transactions")
//public class Transaction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
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
//
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//
//    @UpdateTimestamp
//    private LocalDateTime updatedAt;
//}
