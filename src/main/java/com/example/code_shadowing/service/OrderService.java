package com.example.code_shadowing.service;

import com.example.code_shadowing.dto.OrderRequest;
import com.example.code_shadowing.dto.OrderResponse;
import com.example.code_shadowing.entity.Order;
import com.example.code_shadowing.entity.Product;
import com.example.code_shadowing.repository.OrderRepository;
import com.example.code_shadowing.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;

	@Transactional
	public OrderResponse createOrder(OrderRequest request) {
		Product product = productRepository.findById(request.getProductId())
			.orElseThrow(() -> new IllegalArgumentException(
				"해당 상품이 존재하지 않습니다. id=" + request.getProductId()));

		Order order = new Order(product);
		Order savedOrder = orderRepository.save(order);

		return new OrderResponse(savedOrder);
	}

	public OrderResponse getOrder(Long id) {
		Order order = orderRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException(
				"해당 주문이 존재하지 않습니다. id=" + id));

		return new OrderResponse(order);
	}
}