package com.unwe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unwe.entities.Spent;
import com.unwe.repositories.SpentRepository;;

@Service
public class SpentService {
    @Autowired
    private SpentRepository spentRepository;

    // Save spent instance
    public Spent saveSpent(Spent stk) {
        return spentRepository.save(stk);
    }

    public List<Spent> fetchSpent() {
        return (List<Spent>) spentRepository.findAll();
    }

    public Optional<Spent> fetchSpentbyDate(Long id) {
        return spentRepository.findById(id);
    }

    public Spent updateSpent(Spent stk) {
        Spent tem = spentRepository.findById(stk.getId()).get();
        tem.setTextTitle(stk.getTextTitle());
        tem.setAmountEnter(stk.getAmountEnter());
        tem.setExchangeDate(stk.getExchangeDate());
        return spentRepository.save(stk);
    }

    public void deleteSpentById(Long id) {
        spentRepository.deleteById(id);
    }
}
