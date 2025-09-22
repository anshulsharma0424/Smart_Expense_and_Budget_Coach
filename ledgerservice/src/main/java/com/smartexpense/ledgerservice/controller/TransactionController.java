//package com.smartexpense.ledgerservice.controller;
//
//import com.smartexpense.ledgerservice.dto.TransactionRequest;
//import com.smartexpense.ledgerservice.dto.TransactionResponse;
//import com.smartexpense.ledgerservice.service.TransactionService;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/ledger/transactions")
//public class TransactionController {
//
//    private final TransactionService transactionService;
//
//    // Constructor injection of TransactionService
//    public TransactionController(TransactionService transactionService) {
//        this.transactionService = transactionService;
//    }
//
//    // Create a transaction
//    @PostMapping
//    public ResponseEntity<TransactionResponse> createTransaction (@RequestBody TransactionRequest transactionRequest) {
//        return ResponseEntity.ok(transactionService.createTransaction(transactionRequest));
//    }
//
//    // 2. List transactions for user with optional date filter
//    @GetMapping
//    public ResponseEntity<List<TransactionResponse>> getTransactions(
//            @RequestParam Long userId,
//            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
//            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
//
//        List<TransactionResponse> transactions;
//
//        if (startDate != null && endDate != null) {
//            transactions = transactionService.getTransactionsForUserBetween(userId, startDate, endDate);
//        } else {
//            transactions = transactionService.getTransactionsForUser(userId);
//        }
//        return ResponseEntity.ok(transactions);
//    }
//
//    // 3. Get single transaction by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable Long id) {
//        TransactionResponse txn = transactionService.getTransactionById(id);
//        return ResponseEntity.ok(txn);
//    }
//
//    // 4. Update an existing transaction
//    @PutMapping("/{id}")
//    public ResponseEntity<TransactionResponse> updateTransaction(@PathVariable Long id,
//                                                                 @Valid @RequestBody AddTransactionRequest request) {
//        TransactionResponse updated = transactionService.updateTransaction(id, request);
//        return ResponseEntity.ok(updated);
//    }
//
//    // 5. Delete a transaction
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
//        transactionService.deleteTransaction(id);
//        return ResponseEntity.noContent().build();
//    }
//}
