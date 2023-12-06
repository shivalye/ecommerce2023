package com.telran.ecommerce.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID cartId;
    private final UUID userId;

    @Setter
    private LinkedHashMap<UUID, Integer> products = new LinkedHashMap<>();
    @Setter
    private double totalSum;
    @Setter
    private Shipping shipping;

    public Cart(UUID cartId, UUID userId, UUID productId, int amount, double totalSum, Shipping shipping) {
        this.cartId = cartId;
        this.userId = userId;
        products.put(productId, amount);
        this.totalSum = totalSum;
        this.shipping = shipping;
    }
}

enum Shipping {
    FREE_SHIPPING("free shipping"), EXPRESS_SHIPPING("express shipping"), PICK_UP("pick up");
    final String shipping;

    Shipping(String shipping) {
        this.shipping = shipping;
    }
}