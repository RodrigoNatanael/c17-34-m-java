package com.c174.controllers;

import com.c174.exception.AlreadyExistsException;
import com.c174.models.category.CategoryRequest;
import com.c174.models.category.CategoryResponse;
import com.c174.services.abstraccion.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll(){
        return new ResponseEntity<List<CategoryResponse>>(categoryService.getAllCategories(), HttpStatus.OK);

    }
    @PostMapping("/save")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryRequest category) throws AlreadyExistsException {
        try {
            return new ResponseEntity<CategoryResponse>(categoryService.saveCategory(category), HttpStatus.OK);
        } catch (AlreadyExistsException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        return new ResponseEntity<String>("Entity delete", HttpStatus.OK);
    }
}
