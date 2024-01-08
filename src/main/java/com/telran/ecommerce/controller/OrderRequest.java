package com.telran.ecommerce.controller;

import com.telran.ecommerce.types.PaymentMethod;
import com.telran.ecommerce.types.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class OrderRequest {
    @Getter
    private UUID cartId;
    private String contact;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDate dateOrder;
    private PaymentMethod paymentMethod;
    private Status status;

    public OrderRequest(UUID cartId, String contact, String address, String phoneNumber, String email,
                        LocalDate dateOrder, PaymentMethod paymentMethod, Status status) {
        this.cartId = cartId;
        this.contact = contact;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOrder = dateOrder;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

}

