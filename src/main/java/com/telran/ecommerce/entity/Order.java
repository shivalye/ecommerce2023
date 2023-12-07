package com.telran.ecommerce.entity;

import com.telran.ecommerce.types.PaymentMethod;
import com.telran.ecommerce.types.Shipping;
import com.telran.ecommerce.types.Status;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID orderId;
    private final UUID userId;
    private final LinkedHashMap<UUID, Integer> products;
    private final double totalSum;
    private final Shipping shipping;
    private final String contact;
    private final String address;
    private final String phoneNumber;
    private final String email;
    private final LocalDate dateOrder;
    private final PaymentMethod paymentMethod;
    @Setter
    private Status status;

    public Order(UUID orderId, UUID userId, LinkedHashMap<UUID, Integer> products, double totalSum, Shipping shipping, String contact,
                 String address, String phoneNumber, String email, PaymentMethod paymentMethod, Status status) {
        this.orderId = orderId;
        this.userId = userId;
        this.products = products;
        this.totalSum = totalSum;
        this.shipping = shipping;
        this.contact = contact;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOrder = LocalDate.now();
        this.paymentMethod = paymentMethod;
        this.status = status;
    }
}

