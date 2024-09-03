package com.restaurant.restaurant.service.impl;

import com.restaurant.restaurant.entity.Category;
import com.restaurant.restaurant.repository.CategoryRepository;
import com.restaurant.restaurant.service.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryServiceInterface {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(String id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public String deleteCategory(String id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return "Category deleted successfully";
        }
        return "Category not found";
    }
}
