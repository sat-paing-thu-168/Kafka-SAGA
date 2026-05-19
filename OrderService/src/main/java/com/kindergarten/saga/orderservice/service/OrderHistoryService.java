package com.kindergarten.saga.orderservice.service;

import com.kindergarten.saga.core.types.OrderStatus;
import com.kindergarten.saga.orderservice.dto.OrderHistory;

import java.util.List;
import java.util.UUID;

public interface OrderHistoryService {
    void add(UUID orderId, OrderStatus orderStatus);

    List<OrderHistory> findByOrderId(UUID orderId);
}

