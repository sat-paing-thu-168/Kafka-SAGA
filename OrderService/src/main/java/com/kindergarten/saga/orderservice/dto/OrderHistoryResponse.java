package com.kindergarten.saga.orderservice.dto;

import com.kindergarten.saga.core.types.OrderStatus;

import java.sql.Timestamp;
import java.util.UUID;

public class OrderHistoryResponse {
    private UUID id;
    private UUID orderId;
    private OrderStatus status;
    private Timestamp createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderHistoryResponse{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
