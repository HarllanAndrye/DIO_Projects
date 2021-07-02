package com.harllan.dio.productcatalog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.harllan.dio.productcatalog.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {
	
	List<Product> findByName(String name);

}
