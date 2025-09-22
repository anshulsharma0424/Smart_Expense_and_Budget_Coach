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

    // Create
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        Category category = categoryRepository.findById(transactionRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id " + transactionRequest.getCategoryId()));

        Transaction transaction = TransactionMapper.toTransactionEntity(transactionRequest, category);
        Transaction saved = transactionRepository.save(transaction);
        return TransactionMapper.toTransactionResponse(saved);
    }

    // Get all transactions for user
    public List<TransactionResponse> getTransactionsForUser(Long userId) {
        List<Transaction> transactions = transactionRepository.findAll()
                .stream()
                .filter(tx -> tx.getUserId().equals(userId))
                .toList();
        return transactions.stream()
                .map(TransactionMapper::toTransactionResponse)
                .collect(Collectors.toList());
    }

    // Get transactions for user between dates
    public List<TransactionResponse> getTransactionsForUserBetween(Long userId, LocalDateTime start, LocalDateTime end) {
        List<Transaction> transactions = transactionRepository.findAll()
                .stream()
                .filter(tx -> tx.getUserId().equals(userId)
                        && !tx.getTransactionDate().isBefore(start)
                        && !tx.getTransactionDate().isAfter(end))
                .toList();
        return transactions.stream()
                .map(TransactionMapper::toTransactionResponse)
                .collect(Collectors.toList());
    }

    // Get by ID
    public TransactionResponse getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id " + id));
        return TransactionMapper.toTransactionResponse(transaction);
    }

    // Update
    public TransactionResponse updateTransaction(Long id, TransactionRequest request) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id " + id));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with id " + request.getCategoryId()));

        transaction.setUserId(request.getUserId());
        transaction.setCategory(category);
        transaction.setAmount(request.getAmount());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setTransactionDate(request.getTransactionDate());
        transaction.setMerchant(request.getMerchant());
        transaction.setNote(request.getNote());

        Transaction updated = transactionRepository.save(transaction);
        return TransactionMapper.toTransactionResponse(updated);
    }

    // Delete
    public void deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new TransactionNotFoundException("Transaction not found with id " + id);
        }
        transactionRepository.deleteById(id);
    }
}
