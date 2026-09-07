package com.project.course.resources;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.course.entities.Category;
import com.project.course.services.CategoryService;

@RestController
@RequestMapping (value="/categories")
public class CategoryResource {
    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Set<Category>> findAll(){
        Set<Category> categories = categoryService.findAll();
        
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Category> findById(Long id){
        Category category = categoryService.findById(id);

        return ResponseEntity.ok().body(category);
    }
}
