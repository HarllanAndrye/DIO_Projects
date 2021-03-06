package com.harllan.dio.springcachedemo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String sku;
    private BigDecimal price;
    private String description;
    private Boolean active;

}
