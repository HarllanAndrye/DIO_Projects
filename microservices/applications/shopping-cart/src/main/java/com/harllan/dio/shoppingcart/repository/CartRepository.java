package com.harllan.dio.shoppingcart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.harllan.dio.shoppingcart.entity.Cart;

public interface CartRepository extends MongoRepository<Cart, Integer> {
	
}
