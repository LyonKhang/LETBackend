package com.unwe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unwe.entities.Category;
import com.unwe.repositories.CategoryRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;;

@Service
@RequiredArgsConstructor

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public void addNewCategory(Category category) {
        categoryRepository.save(category);
    }

    // GET
    public Category getCategoryById(Long categoryId) {
        Optional<Category> tem = categoryRepository.findById(categoryId);
        return tem.get();
    }

    // PUT
    @Transactional
    public ResponseEntity<Category> updateCategory() {
        return null;
    }
    // DELETE

}
