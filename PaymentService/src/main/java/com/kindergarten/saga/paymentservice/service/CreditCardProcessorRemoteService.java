package com.kindergarten.saga.paymentservice.service;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface CreditCardProcessorRemoteService {
    void process(BigInteger cardNumber, BigDecimal paymentAmount);
}
