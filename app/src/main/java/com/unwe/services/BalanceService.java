package com.unwe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unwe.entities.Transaction;
import com.unwe.repositories.BalanceRepository;
import com.unwe.repositories.TransactionRepository;

@Service
public class BalanceService {
    @Autowired
    private BalanceRepository balancerepository;
    @Autowired
    private TransactionRepository transactionrepository;

    private double balance;

    public double getBalance() {
        return balance;
    }

    public double calculateBalance() {
        List<Transaction> transactions = (List<Transaction>) transactionrepository.findAll();
        double totalBalance = 0.0;
        for (Transaction transaction : transactions) {
            totalBalance += transaction.getAmountEnter();
        }
        return totalBalance;
    }
}
