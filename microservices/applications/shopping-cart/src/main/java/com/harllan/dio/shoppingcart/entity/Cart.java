package com.harllan.dio.shoppingcart.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cart")
public class Cart {
	
	@Id
	private Integer id;
    
	private List<Item> items;
	
	public Cart(Integer id) {
        this.id = id;
    }

}
