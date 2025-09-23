package com.smartexpense.ledgerservice.service;

import com.smartexpense.ledgerservice.dto.TransactionRequest;
import com.smartexpense.ledgerservice.dto.TransactionResponse;
import com.smartexpense.ledgerservice.entity.Category;
import com.smartexpense.ledgerservice.entity.Transaction;
import com.smartexpense.ledgerservice.exception.TransactionNotFoundException;
import com.smartexpense.ledgerservice.mapper.TransactionMapper;
import com.smartexpense.ledgerservice.repository.CategoryRepository;
import com.smartexpense.ledgerservice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public TransactionService(TransactionRepository transactionRepository,  CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    // Create transaction
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        Category category = categoryRepository.findById(transactionRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id " + transactionRequest.getCategoryId()));

        Transaction transaction = TransactionMapper.toTransactionEntity(transactionRequest, category);
        Transaction saved = transactionRepository.save(transaction);
        return TransactionMapper.toTransactionResponse(saved);
    }

    // Get all transactions for user
    public List<TransactionResponse> getTransactionsForUser(Long userId) {
        return transactionRepository.findByUserId(userId)
                .stream()
                .map(TransactionMapper::toTransactionResponse)
                .toList();
    }

    // Get transactions for user between dates
    public List<TransactionResponse> getTransactionsForUserBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByUserIdAndTransactionDateBetween(userId, startDate, endDate)
                .stream()
                .map(TransactionMapper::toTransactionResponse)
                .toList();
    }

    // Get transaction by transactionID
    public TransactionResponse getTransactionById(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id " + transactionId));
        return TransactionMapper.toTransactionResponse(transaction);
    }

    // Update transaction
    public TransactionResponse updateTransaction(Long id, TransactionRequest request) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id " + id));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id " + request.getCategoryId()));

        TransactionMapper.updateTransactionEntity(transaction, request, category);

        Transaction updated = transactionRepository.save(transaction);
        return TransactionMapper.toTransactionResponse(updated);
    }

    // Delete transaction
    public void deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new TransactionNotFoundException("Transaction not found with id " + id);
        }
        transactionRepository.deleteById(id);
    }
}
