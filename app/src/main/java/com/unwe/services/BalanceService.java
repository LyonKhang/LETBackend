package com.unwe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unwe.entities.Transaction;
import com.unwe.repositories.SpentRepository;
import com.unwe.repositories.TransactionRepository;

@Service
public class BalanceService {
    // @Autowired
    // private BalanceRepository balancerepository;
    @Autowired
    private SpentRepository spentrepository;
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

    // TODO: create a get bv location
    public double getLocationbyOption() {

        return balance;

    }
}
