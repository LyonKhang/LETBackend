package com.unwe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unwe.entities.Category;
import com.unwe.services.CategoryService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryservice;

    @PostMapping(value = "/newcategory")
    @CrossOrigin
    public Category addcategory(@RequestBody Category ctg) {
        System.out.println("add " + ctg.getName());
        return categoryservice.saveCategory(ctg);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/getcategory")
    public List<Category> getCategory() {
        System.out.println("get Category");
        return categoryservice.getCategories();
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PutMapping("/editCatergory/{CurrentCategoryName}")
    public ResponseEntity<Category> editCategory(@PathVariable String CurrentCategoryName, @RequestBody Category ctg) {
        System.out.println("edit " + CurrentCategoryName);
        return categoryservice.updateCategory(CurrentCategoryName, ctg);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping("/deleteCatergory")
    public void deletecategory(@PathVariable long id) {
        categoryservice.deleteStockById(id);
    }
}
