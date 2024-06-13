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

import com.unwe.entities.Spent;
import com.unwe.services.SpentService;

@RestController
@RequestMapping("/spents")
public class SpentController {
    @Autowired
    private SpentService spentservice;

    @PostMapping(value = "/newspents")
    @CrossOrigin
    public Spent addSpent(@RequestBody Spent stk) {
        System.out.println("new spent " + stk.getTextTitle());
        return spentservice.saveSpent(stk);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/getspents")
    public List<Spent> getSpent() {
        System.out.println("get spent");
        return spentservice.fetchSpent();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping("/editspent")
    public Spent editspent(@RequestBody Spent stk) {
        System.out.println("edit spent " + stk.getAmountEnter());
        return spentservice.updateSpent(stk);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping("/deletespent/{id}")
    public void deletespent(@PathVariable Long id) {
        System.out.println("delete spent " + id);
        spentservice.deleteSpentById(id);
    }

}