package com.c174.services.abstraccion;

import com.c174.exception.AlreadyExistsException;
import com.c174.models.category.CategoryRequest;
import com.c174.models.category.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse getByName(String name);
    CategoryResponse saveCategory(CategoryRequest category) throws AlreadyExistsException;
    String deleteCategory(Long id);
}
