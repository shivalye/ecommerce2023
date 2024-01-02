package com.telran.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID orderId;

    private UUID userId;
    private Map<String, Integer> products = new HashMap<>();
    private double totalSum;
    private ShippingOption shippingOption;
    private String contactName;
    private Address address;
    private String phoneNumber;
    private String email;
    private LocalDateTime dateOrder;
    private PaymentMethod paymentMethod;
    private Status status;

    public Order(UUID userId, Map<String, Integer> products, double totalSum, ShippingOption shippingOption,
                 String contactName, Address address, String phoneNumber, String email,
                 LocalDateTime dateOrder, PaymentMethod paymentMethod, Status status) {
        this.userId = userId;
        this.products = products;
        this.totalSum = totalSum;
        this.shippingOption = shippingOption;
        this.contactName = contactName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOrder = dateOrder;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Integer> products) {
        this.products = products;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public ShippingOption getShippingOption() {
        return shippingOption;
    }

    public void setShippingOption(ShippingOption shippingOption) {
        this.shippingOption = shippingOption;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    public void addProduct(String productId, int quantity) {
        this.products.put(productId, this.products.getOrDefault(productId, 0) + quantity);

        calculateTotalSum();
    }

    public void removeProduct(String productId, int quantity) {
        int currentQuantity = this.products.getOrDefault(productId, 0);
        if (currentQuantity <= quantity) {
            this.products.remove(productId);
        } else {
            this.products.put(productId, currentQuantity - quantity);
        }

        calculateTotalSum();
    }

    public void clearOrder() {
        this.products.clear();
        this.totalSum = 0.0;
    }

    public int getTotalProducts() {
        return this.products.size();
    }

    public void calculateTotalSum() {

        double sum = 0.0;
        for (Map.Entry<String, Integer> entry : products.entrySet()) {

            double price = getProductPriceById(entry.getKey());
            sum += price * entry.getValue();
        }
        this.totalSum = sum;
    }

    private double getProductPriceById(String productId) {
        // TODO
        return 0.0; // Временное значение для примера
    }

    public void confirmOrder() {
        // TODO
        this.status = Status.CONFIRMED;
    }

    public void cancelOrder() {
        // TODO
        this.status = Status.CANCELLED;
    }

    public void updateShippingOption(ShippingOption option) {
        this.shippingOption = option;
    }

    public void updatePaymentMethod(PaymentMethod method) {
        this.paymentMethod = method;
    }

    public void updateAddress(Address newAddress) {
        this.address = newAddress;
    }
}

