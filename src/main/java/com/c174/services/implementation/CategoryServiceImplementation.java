package com.c174.services.implementation;

import com.c174.exception.AlreadyExistsException;
import com.c174.models.category.CategoryEntity;
import com.c174.models.category.CategoryRequest;
import com.c174.models.category.CategoryResponse;
import com.c174.repositorys.CategoryRepository;
import com.c174.services.abstraccion.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = categories.stream()
                .map(CategoryResponse::new).collect(Collectors.toList());
        return categoryResponses;
    }

    @Override
    public CategoryResponse getByName(String name) {
        return categoryRepository.findByName(name).map(CategoryResponse::new).orElse(null);
    }

    @Override
    public CategoryResponse saveCategory(CategoryRequest category) throws AlreadyExistsException {
        if(categoryRepository.existsByName(category.getName())){
            throw new AlreadyExistsException("Category already exists");
        }
        CategoryEntity categoryEntity = new CategoryEntity(category);
        return new CategoryResponse(categoryRepository.save(categoryEntity));
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Entity delete";
    }
}
