package com.yuva.yuvaranistore.service;

import com.yuva.yuvaranistore.dto.OrderRequestDto;

public interface IOrderService {
	void createOrder(
			OrderRequestDto orderRequest);
}
