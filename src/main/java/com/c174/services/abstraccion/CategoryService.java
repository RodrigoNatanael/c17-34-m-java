package com.c174.services.abstraccion;

import com.c174.exception.AlreadyExistsException;
import com.c174.models.ticket.CategoryEntity;
import com.c174.models.ticket.CategoryRequest;
import com.c174.models.ticket.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse getByName(String name);
    CategoryResponse saveCategory(CategoryRequest category) throws AlreadyExistsException;
    String deleteCategory(Long id);
}
