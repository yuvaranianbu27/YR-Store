package com.yuva.yuvaranistore.dto;
import java.math.BigDecimal;

public record OrderItemDto(Long productId, Integer quantity, BigDecimal price) {
}