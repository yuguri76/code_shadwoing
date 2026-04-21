package com.example.code_shadowing.repository;

import com.example.code_shadowing.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}