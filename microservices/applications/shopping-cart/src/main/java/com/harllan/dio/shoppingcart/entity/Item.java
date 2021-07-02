package com.harllan.dio.shoppingcart.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "item")
public class Item {
	
	@Id
	private Integer productId;
    
	private Integer amount;

}
