package com.example.code_shadowing.Repository;

import com.example.code_shadowing.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//2회차
public interface ProductRepository extends JpaRepository<Product, Long> {
}
