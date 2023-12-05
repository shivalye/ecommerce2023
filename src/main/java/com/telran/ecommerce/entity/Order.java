package com.telran.ecommerce.entity;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.UUID;

public class Order {
    private UUID orderId;
    private UUID userId;
    private LinkedHashMap products;
    private double totalSum;
    private Shipping shipping;
    private String contact;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDate dateOrder;
    private PaymentMethod paymentMethod;
    private Status status;
}

enum PaymentMethod{
    CREDIT_CARD, PAYPAL;
}

enum Status{
    PREPARED_TO_DELIVERY, IN_DELIVERY, DELIVERED, FINISHING;
}
