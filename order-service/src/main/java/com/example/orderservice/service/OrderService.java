package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;

public interface OrderService {

    Long placeOrder(OrderDto orderDto);
    OrderDto getOrderDetails(Long id);
}
