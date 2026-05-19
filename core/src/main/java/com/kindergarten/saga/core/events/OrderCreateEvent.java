package com.kindergarten.saga.core.events;

import java.util.UUID;

public class OrderCreateEvent {
    private UUID orderId;
    private UUID customerId;
    private UUID productId;
    private Integer productQuantity;

    public OrderCreateEvent() {
    }

    public OrderCreateEvent(UUID orderId, UUID customerId, UUID productId, Integer productQuantity) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "OrderCreateEvent{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
