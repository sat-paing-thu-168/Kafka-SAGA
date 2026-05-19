package com.kindergarten.saga.orderservice.service;

import com.kindergarten.saga.core.dto.Order;

public interface OrderService {
    Order placeOrder(Order order);
}
