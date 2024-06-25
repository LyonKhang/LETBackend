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

import com.unwe.model.Selection;
import com.unwe.services.SelectionService;

@RestController
@RequestMapping("/companys")
public class SelectionController {
    @Autowired
    private SelectionService companyservice;

    @PostMapping(value = "/newcompanys")
    @CrossOrigin
    public Selection addCompany(@RequestBody Selection cpy) {
        System.out.println("new selection " + cpy.getCategory());
        return companyservice.saveCompany(cpy);
    }

    @GetMapping("/getcompanys")
    public List<Selection> getCompany() {
        System.out.println("get selection");
        return companyservice.fetchCompany();
    }

    @PutMapping("/editcompany")
    public Selection editcompany(@RequestBody Selection cpy) {
        System.out.println("edit selection " + cpy.getPayment());
        return companyservice.updateCompany(cpy);
    }

    @DeleteMapping("/deletecompany/{id}")
    public void deletecompany(@PathVariable Long id) {
        System.out.println("delete selection " + id);
        companyservice.deleteCompanyById(id);
    }
}
