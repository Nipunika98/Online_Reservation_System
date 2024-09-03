package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.Category;
import com.restaurant.restaurant.service.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryServiceInterface categoryServiceInterface;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryServiceInterface.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable String id) {
        return categoryServiceInterface.getCategory(id);
    }

    @PostMapping("/categories/add")
    public Category addNewCategory(@RequestBody Category category) {
        return categoryServiceInterface.addNewCategory(category);
    }

    @PutMapping("/categories/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryServiceInterface.updateCategory(category);
    }

    @DeleteMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable String id) {
        return categoryServiceInterface.deleteCategory(id);
    }
}
