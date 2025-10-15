package com.yuva.yuvaranistore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yuva.yuvaranistore.entity.Order;

public interface OrderRepository extends
		JpaRepository<Order, Long> {
}