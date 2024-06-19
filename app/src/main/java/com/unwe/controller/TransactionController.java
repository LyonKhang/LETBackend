package com.unwe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unwe.entities.Transaction;
import com.unwe.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionservice;

    @PostMapping(value = "/newtransactions")
    @CrossOrigin
    public Transaction addTransaction(@RequestBody Transaction tsn) {
        System.out.println("new transaction " + tsn.getTextTitle());
        return transactionservice.saveTransaction(tsn);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/gettransactions")
    public List<Transaction> getTransaction() {
        System.out.println("get transaction");
        return transactionservice.fetchTransaction();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping("/edittransaction")
    public Transaction edittransaction(@RequestBody Transaction tsn) {
        System.out.println("edit transaction " + tsn.getAmountEnter());
        return transactionservice.updateTransaction(tsn);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deletetransaction/{id}")
    public void deletetransaction(@PathVariable Long id) {
        System.out.println("delete transaction " + id);
        transactionservice.deleteTransactionById(id);
    }
}
