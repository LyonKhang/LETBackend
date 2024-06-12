package com.unwe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unwe.entities.Stock;
import com.unwe.repositories.StockRepository;;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    // Save stock instance
    public Stock saveStock(Stock stk) {
        return stockRepository.save(stk);
    }

    public List<Stock> fetchStock() {
        return (List<Stock>) stockRepository.findAll();
    }

    public Stock updateStock(Stock stk) {
        Stock tem = stockRepository.findById(stk.getId()).get();
        if (tem.getTextTitle() != stk.getTextTitle()) {
            tem.setTextTitle(stk.getTextTitle());
        }
        if (tem.getAmountEnter() != stk.getAmountEnter()) {
            tem.setAmountEnter(stk.getAmountEnter());
        }
        System.out.println(tem.getAmountEnter());
        return stockRepository.save(stk);
    }

    public void deleteStockById(Long id) {
        stockRepository.deleteById(id);
    }
}
