package com.project.course.resources;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.course.entities.Product;
import com.project.course.services.ProductService;

@RestController
@RequestMapping (value="/products")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Set<Product>> findAll(){
        Set<Product> products = productService.findAll();

        return ResponseEntity.ok().body(products);
    }

    @GetMapping (value="/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product product = productService.findById(id);

        return ResponseEntity.ok().body(product);
    }
}
