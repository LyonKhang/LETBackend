package com.unwe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unwe.entities.Selection;
import com.unwe.repositories.SelectionRepository;

@Service
public class SelectionService {
    @Autowired
    private SelectionRepository selectionRepository;

    public Selection saveSelection(Selection cpy) {
        return selectionRepository.save(cpy);
    }

    public List<Selection> fetchSelection() {
        return (List<Selection>) selectionRepository.findAll();
    }

    public Optional<Selection> fetchSelectionById(Long id) {
        return selectionRepository.findById(id);
    }

    public Selection updateSelection(Selection cpy) {
        Selection tem = selectionRepository.findById(cpy.getId()).get();
        tem.setCategory(cpy.getCategory());
        tem.setPayment(cpy.getPayment());
        return selectionRepository.save(cpy);
    }

    public void deleteSelectionById(Long id) {
        selectionRepository.deleteById(id);
    }

}
