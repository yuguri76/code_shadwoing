package com.example.code_shadowing.dto;

import com.example.code_shadowing.entity.Product;
import lombok.Getter;

//3회차
@Getter
public class ProductResponse {

    private final Long id;
    private final String name;
    private final Integer price;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }
}