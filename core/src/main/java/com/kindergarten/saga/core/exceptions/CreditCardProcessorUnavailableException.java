package com.kindergarten.saga.core.exceptions;

public class CreditCardProcessorUnavailableException extends RuntimeException {
    public CreditCardProcessorUnavailableException(String message) {
        super(message);
    }

    public CreditCardProcessorUnavailableException(Throwable cause) {
        super(cause);
    }
}
