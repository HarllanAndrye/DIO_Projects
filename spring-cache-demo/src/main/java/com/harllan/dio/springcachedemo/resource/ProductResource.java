package com.harllan.dio.springcachedemo.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harllan.dio.springcachedemo.entity.Product;
import com.harllan.dio.springcachedemo.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductResource {
	
	private final ProductService productService;

    @GetMapping
    public List<Product> listAll() {
        log.info("c=ProductResource, m=listAll");
        return productService.listAll();
    }

}
