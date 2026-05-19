package com.kindergarten.saga.core.dto;

import java.util.UUID;

public class Shipment {
    private UUID id;
    private UUID orderId;
    private UUID paymentId;

    public Shipment() {
    }

    public Shipment(UUID id, UUID orderId, UUID paymentId) {
        this.id = id;
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

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

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public String toString() {
        return "Shipment{" + "id=" + id + ", orderId=" + orderId + ", paymentId=" + paymentId + '}';
    }
}
