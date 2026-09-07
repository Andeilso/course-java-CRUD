package com.project.course.services;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.project.course.entities.Product;
import com.project.course.repositories.ProductRepository;


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Set<Product> findAll(){
        List<Product> products = productRepository.findAll();

        return new LinkedHashSet<>(products);
    }

    public Product findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        
        return product.get();
    }
}
