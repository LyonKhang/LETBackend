package com.unwe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unwe.entities.Company;
import com.unwe.repositories.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company cpy) {
        return companyRepository.save(cpy);
    }

    public List<Company> fetchCompany() {
        return (List<Company>) companyRepository.findAll();
    }

    public Optional<Company> fetchCompanybyDate(Long id) {
        return companyRepository.findById(id);
    }

    public Company updateCompany(Company cpy) {
        Company tem = companyRepository.findById(cpy.getId()).get();
        tem.setCompanyname(cpy.getCompanyname());
        tem.setEmail(cpy.getEmail());
        return companyRepository.save(cpy);
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

}
