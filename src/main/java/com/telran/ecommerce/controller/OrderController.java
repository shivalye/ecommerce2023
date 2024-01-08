package com.telran.ecommerce.controller;

import com.telran.ecommerce.entity.Cart;
import com.telran.ecommerce.service.IOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final IOrder orderService;

    public OrderController(IOrder orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/add")
    public ResponseEntity<UUID> addOrder(@RequestBody OrderRequest orderRequest) {
        Cart cart = new Cart(
                orderRequest.getCartId(),
                orderRequest.getUserId(),
                orderRequest.getProductId(),
                orderRequest.getAmount(),
                orderRequest.getTotalSum(),
                orderRequest.getShipping()
        );

        LocalDate dateOrder = orderRequest.getDateOrder();

        UUID orderId = orderService.addOrder(
                orderRequest.getOrderId(),
                cart,
                orderRequest.getContact(),
                orderRequest.getAddress(),
                orderRequest.getPhoneNumber(),
                orderRequest.getEmail(),
                dateOrder,
                orderRequest.getPaymentMethod(),
                orderRequest.getStatus()
        );

        return ResponseEntity.ok(orderId);
    }
}

