package com.example.code_shadowing.controller;

import com.example.code_shadowing.dto.OrderRequest;
import com.example.code_shadowing.dto.OrderResponse;
import com.example.code_shadowing.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderRequest request) {
		OrderResponse response = orderService.createOrder(request);
		return ResponseEntity
			.created(URI.create("/api/orders/" + response.getOrderId()))
			.body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
		return ResponseEntity.ok(orderService.getOrder(id));
	}
}