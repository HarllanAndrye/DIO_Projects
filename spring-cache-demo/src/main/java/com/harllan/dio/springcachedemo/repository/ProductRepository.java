package com.harllan.dio.springcachedemo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.harllan.dio.springcachedemo.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductRepository {
	
	public List<Product> listAll() {
        log.info("c=ProductRepository, m=listAll");

        // Tempo para simular latência de acesso ao banco de dados
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Acesso ao bandos e retornando a lista;
        final Product product1 = Product.builder()
                .sku("produto123")
                .price(new BigDecimal("10.00"))
                .description("Produto 1")
                .active(false)
                .build();

        final Product product2 = Product.builder()
                .sku("produto987")
                .price(new BigDecimal("7.90"))
                .description("Produto 2")
                .active(true)
                .build();

        List<Product> products = List.of(product1, product2);

        return products;
    }

}
