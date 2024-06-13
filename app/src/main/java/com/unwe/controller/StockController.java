package com.unwe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.unwe.entities.Stock;
import com.unwe.services.StockService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {
    @Autowired
    private StockService stockservice;

    @PostMapping(value = "/newstocks")
    @CrossOrigin
    public Stock addStock(@RequestBody Stock stk) {
        System.out.println("new stock " + stk.getId());
        return stockservice.saveStock(stk);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/getstocks")
    public List<Stock> getStock() {
        System.out.println("get stock");
        return stockservice.fetchStock();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping("/editstock")
    public Stock editstock(@RequestBody Stock stk) {
        System.out.println("edit stock " + stk.getAmountEnter());
        return stockservice.updateStock(stk);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping("/deletestock/{id}")
    public void deletestock(@PathVariable Long id) {
        System.out.println("delete stock " + id);
        stockservice.deleteStockById(id);
    }

}