package com.harllan.dio.productcatalog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harllan.dio.productcatalog.entity.Product;
import com.harllan.dio.productcatalog.repository.ProductRepository;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public Iterable<Product> list() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable("id") Integer id) {
        return productRepository.findById(id);
    }

    @GetMapping("/name/{name}")
    public Iterable<Product> findByName(@PathVariable("name") String name) {
        return productRepository.findByName(name);
    }

}
