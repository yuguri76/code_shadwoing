package com.example.code_shadowing.dto;

import com.example.code_shadowing.entity.Order;
import lombok.Getter;

@Getter
public class OrderResponse {

	private final Long orderId;
	private final Long productId;
	private final String productName;
	private final Integer productPrice;

	public OrderResponse(Order order) {
		this.orderId = order.getId();
		this.productId = order.getProduct().getId();
		this.productName = order.getProduct().getName();
		this.productPrice = order.getProduct().getPrice();
	}
}