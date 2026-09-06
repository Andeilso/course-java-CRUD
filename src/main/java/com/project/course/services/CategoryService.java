package com.project.course.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import com.project.course.entities.Category;
import com.project.course.repositories.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Set<Category> findAll(){
        List<Category> categoryList = categoryRepository.findAll();

        return new TreeSet<>(categoryList);
    }

    public Category findById(Long id){
        Optional<Category> category = categoryRepository.findById(id);

        return category.get();
    }

}
