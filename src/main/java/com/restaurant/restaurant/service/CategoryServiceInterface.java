package com.restaurant.restaurant.service;

import com.restaurant.restaurant.entity.Category;

import java.util.List;

public interface CategoryServiceInterface {
    List<Category> getAllCategories();
    Category getCategory(String id);
    Category addNewCategory(Category category);
    Category updateCategory(Category category);
    String deleteCategory(String id);
}
