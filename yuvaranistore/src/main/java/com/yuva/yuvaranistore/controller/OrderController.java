package com.yuva.yuvaranistore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yuva.yuvaranistore.dto.OrderRequestDto;
import com.yuva.yuvaranistore.service.IOrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final IOrderService iOrderService;

    public OrderController(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }


    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody  OrderRequestDto requestDto) {
        iOrderService.createOrder(requestDto);
        return ResponseEntity.ok("Order created successfully!");
    }
}