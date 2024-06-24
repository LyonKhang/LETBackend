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
    private SelectionRepository companyRepository;

    public Selection saveCompany(Selection cpy) {
        return companyRepository.save(cpy);
    }

    public List<Selection> fetchCompany() {
        return (List<Selection>) companyRepository.findAll();
    }

    public Optional<Selection> fetchCompanybyDate(Long id) {
        return companyRepository.findById(id);
    }

    public Selection updateCompany(Selection cpy) {
        Selection tem = companyRepository.findById(cpy.getId()).get();
        tem.setCategory(cpy.getCategory());
        tem.setPayment(cpy.getPayment());
        return companyRepository.save(cpy);
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

}
