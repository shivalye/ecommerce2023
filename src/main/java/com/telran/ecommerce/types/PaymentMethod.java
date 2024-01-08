package com.telran.ecommerce.types;

public enum PaymentMethod {
    CREDIT_CARD("Pay by Credit Card"), PAYPAL("Paypal"), APPLE_PAY("Apple pay"), GOOGLE_PAY("Google pay"), BANK_TRANSFER("Bank transfer"), CASH_ON_DELIVERY("Cash on delivery");
    final String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
