package com.telran.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cartId;
    private UUID userId;
    private Map<String, Integer> products = new HashMap<>();
    private double totalSum;
    private ShippingOption shippingOption;

    public Cart(UUID userId, String productId, int quantity, double productPrice) {
        this.cartId = UUID.randomUUID(); // Генерация ID корзины
        this.userId = userId;

        this.products = new HashMap<>();
        this.products.put(productId, quantity);

        this.totalSum = quantity * productPrice; // Общая сумма корзины
    }

    // Геттеры
    public UUID getCartId() {
        return cartId;
    }

    public UUID getUserId() {
        return userId;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public ShippingOption getShippingOption() {
        return shippingOption;
    }

    // Сеттеры
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setShippingOption(ShippingOption shippingOption) {
        this.shippingOption = shippingOption;
    }

    // Метод для добавления продукта в корзину
    public void addProduct(String productId, int quantity, double productPrice) {
        this.products.put(productId, this.products.getOrDefault(productId, 0) + quantity);
        this.totalSum += quantity * productPrice;
    }

    // Метод для удаления продукта из корзины
    public void removeProduct(String productId, int quantity, double productPrice) {
        int currentQuantity = this.products.getOrDefault(productId, 0);
        if (currentQuantity <= quantity) {
            this.products.remove(productId);
            this.totalSum -= currentQuantity * productPrice;
        } else {
            this.products.put(productId, currentQuantity - quantity);
            this.totalSum -= quantity * productPrice;
        }
    }

    // Метод для очистки корзины
    public void clearCart() {
        this.products.clear();
        this.totalSum = 0.0;
    }
}
