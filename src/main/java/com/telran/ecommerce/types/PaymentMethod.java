package com.telran.ecommerce.types;

public enum PaymentMethod {
    CREDIT_CARD("credit card"), PAYPAL("paypal");
    final String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
