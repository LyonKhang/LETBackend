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

import com.unwe.entities.Selection;
import com.unwe.services.SelectionService;

@RestController
@RequestMapping("/selections")
public class SelectionController {
    @Autowired
    private SelectionService selectionservice;

    @PostMapping(value = "/newselections")
    @CrossOrigin
    public Selection addselection(@RequestBody Selection cpy) {
        System.out.println("new selection " + cpy.getCategory());
        return selectionservice.saveSelection(cpy);
    }

    @GetMapping("/getselections")
    public List<Selection> getselection() {
        System.out.println("get selection");
        return selectionservice.fetchSelection();
    }

    @PutMapping("/editselection")
    public Selection editselection(@RequestBody Selection cpy) {
        System.out.println("edit selection " + cpy.getCategory());
        return selectionservice.updateSelection(cpy);
    }

    @DeleteMapping("/deleteselection/{id}")
    public void deleteselection(@PathVariable Long id) {
        System.out.println("delete selection " + id);
        selectionservice.deleteSelectionById(id);
    }
}
