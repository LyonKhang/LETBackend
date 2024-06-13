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

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // GET
    public Category getCategoryById(Long categoryId) {
        Optional<Category> tem = categoryRepository.findById(categoryId);
        return tem.get();
    }

    // PUT
    @Transactional
    public ResponseEntity<Category> updateCategory(String CurrentCategoryName, Category category) {
        Optional<Category> tem = categoryRepository.findCategoryByName(CurrentCategoryName);
        tem.get().setName(category.getName());
        Category updatedCategory = categoryRepository.save(tem.get());
        return ResponseEntity.ok(updatedCategory);
    }

    // DELETE
    public void deleteStockById(Long id) {
        categoryRepository.deleteById(id);
    }
}
