package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Cart;
import com.telran.ecommerce.entity.Order;
import com.telran.ecommerce.types.Code;
import com.telran.ecommerce.types.PaymentMethod;
import com.telran.ecommerce.types.Status;

import java.time.LocalDate;
import java.util.UUID;

public interface IOrder {
    UUID addOrder(UUID orderId, Cart cart, String contact, String address, String phoneNumber,
                  String email, LocalDate dateOrder, PaymentMethod paymentMethod, Status status);
    Code setOrderStatus(UUID order, Status status);
    Status getStatus(UUID order);
    Order getOrder(UUID order);
}
