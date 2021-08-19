package com.harllan.dio.springcachedemo.service;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.harllan.dio.springcachedemo.entity.Product;
import com.harllan.dio.springcachedemo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepository;

    @Cacheable(value = "product-cache", key = "")
    public List<Product> listAll() {
        log.info("c=ProductService, m=listAll");
        return productRepository.listAll();
    }

}
