package com.smartexpense.ledgerservice.mapper;

import com.smartexpense.ledgerservice.dto.TransactionRequest;
import com.smartexpense.ledgerservice.dto.TransactionResponse;
import com.smartexpense.ledgerservice.entity.Transaction;

public class TransactionMapper {
    public static Transaction toTransactionEntity(TransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setUserId(request.getUserId());
        transaction.setCategoryId(request.getCategoryId());
        transaction.setAmount(request.getAmount());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setTransactionDate(request.getTransactionDate());
        transaction.setMerchant(request.getMerchant());
        transaction.setNote(request.getNote());

        return transaction;
    }

    public static TransactionResponse toTransactionResponse(Transaction transaction) {
        TransactionResponse response = new TransactionResponse();
        response.setId(transaction.getId());
        response.setUserId(transaction.getUserId());
        response.setCategoryId(transaction.getCategoryId());
        response.setAmount(transaction.getAmount());
        response.setTransactionType(transaction.getTransactionType());
        response.setTransactionDate(transaction.getTransactionDate());
        response.setMerchant(transaction.getMerchant());
        response.setNote(transaction.getNote());
        response.setCreatedAt(transaction.getCreatedAt());
        response.setUpdatedAt(transaction.getUpdatedAt());

        return response;
    }
}
