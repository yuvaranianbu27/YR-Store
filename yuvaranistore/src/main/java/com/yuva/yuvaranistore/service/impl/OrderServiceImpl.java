package com.yuva.yuvaranistore.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import com.yuva.yuvaranistore.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.yuva.yuvaranistore.constants.ApplicationConstants;
import com.yuva.yuvaranistore.dto.OrderRequestDto;
import com.yuva.yuvaranistore.entity.Customer;
import com.yuva.yuvaranistore.entity.Order;
import com.yuva.yuvaranistore.entity.OrderItem;
import com.yuva.yuvaranistore.entity.Product;
import com.yuva.yuvaranistore.repository.OrderRepository;
import com.yuva.yuvaranistore.repository.ProductRepository;
import com.yuva.yuvaranistore.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ProfileServiceImpl profileService;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, ProfileServiceImpl profileService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.profileService = profileService;
    }

    @Override
    public void createOrder(OrderRequestDto orderRequest) {
        Customer customer = profileService.getAuthenticatedCustomer();

        // Create Order
        Order order = new Order();
        order.setCustomer(customer);
        BeanUtils.copyProperties(orderRequest, order);
        order.setOrderStatus(ApplicationConstants.ORDER_STATUS_CREATED);
        // Map OrderItems
        List<OrderItem> orderItems = orderRequest.items().stream().map(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            Product product = productRepository.findById(item.productId())
                    .orElseThrow(() -> new ResourceNotFoundException("Product", "ProductID",
                            item.productId().toString()));
            orderItem.setProduct(product);
            orderItem.setQuantity(item.quantity());
            orderItem.setPrice(item.price());
            return orderItem;
        }).collect(Collectors.toList());
        order.setOrderItems(orderItems);
        orderRepository.save(order);

    }
}

