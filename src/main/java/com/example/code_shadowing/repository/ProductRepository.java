package com.example.code_shadowing.repository;

import com.example.code_shadowing.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//3회차
public interface ProductRepository extends JpaRepository<Product, Long> {
}