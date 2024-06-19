package com.unwe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unwe.services.BalanceService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/balance")

public class BalanceController {

    @Autowired
    private BalanceService balanceservice;

    @GetMapping("/calculateBalance")
    @CrossOrigin(origins = "http://localhost:3000/")
    public double calculateBalance() {
        return balanceservice.calculateBalance();
    }
}
