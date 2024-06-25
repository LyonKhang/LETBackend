package com.unwe.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unwe.model.Transaction;
import com.unwe.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    // Save transaction instance
    public Transaction saveTransaction(Transaction tsn) {
        return transactionRepository.save(tsn);
    }

    public List<Transaction> fetchTransaction() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    public Optional<Transaction> fetchTransactionbyDate(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction updateTransaction(Transaction tsn) {
        Transaction tem = transactionRepository.findById(tsn.getId()).get();
        tem.setTextTitle(tsn.getTextTitle());
        tem.setAmountEnter(tsn.getAmountEnter());
        tem.setExchangeDate(tsn.getExchangeDate());
        tem.setSelection(tsn.getSelection());
        tem.setSpent(tsn.getSpent());
        return transactionRepository.save(tsn);
    }

    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }

}
