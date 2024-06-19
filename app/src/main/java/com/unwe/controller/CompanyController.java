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

import com.unwe.entities.Company;
import com.unwe.services.CompanyService;

@RestController
@RequestMapping("/companys")
public class CompanyController {
    @Autowired
    private CompanyService companyservice;

    @PostMapping(value = "/newcompanys")
    @CrossOrigin
    public Company addCompany(@RequestBody Company cpy) {
        System.out.println("new company " + cpy.getCompanyname());
        return companyservice.saveCompany(cpy);
    }

    @GetMapping("/getcompanys")
    public List<Company> getCompany() {
        System.out.println("get company");
        return companyservice.fetchCompany();
    }

    @PutMapping("/editcompany")
    public Company editcompany(@RequestBody Company cpy) {
        System.out.println("edit company " + cpy.getEmail());
        return companyservice.updateCompany(cpy);
    }

    @DeleteMapping("/deletecompany/{id}")
    public void deletecompany(@PathVariable Long id) {
        System.out.println("delete company " + id);
        companyservice.deleteCompanyById(id);
    }
}
