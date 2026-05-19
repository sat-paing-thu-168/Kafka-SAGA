package com.kindergarten.saga.paymentservice.service;

import com.kindergarten.saga.core.dto.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAll();

    Payment process(Payment payment);
}
