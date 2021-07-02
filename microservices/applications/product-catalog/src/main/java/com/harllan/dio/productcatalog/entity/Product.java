package com.harllan.dio.productcatalog.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "product")
public class Product {

	@Id
	private Integer id;
	
	private String name;
	
	private Integer amount;
	
}
