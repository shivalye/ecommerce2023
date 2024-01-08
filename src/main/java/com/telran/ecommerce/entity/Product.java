package com.telran.ecommerce.entity;

import com.telran.ecommerce.types.CategoryName;
import com.telran.ecommerce.types.Color;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


import java.time.LocalDate;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = "productId")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;
    private String productName;
    @Setter
    private double price;
    public CategoryName categoryName;
    private String measurements;
    public Color color;
    @Setter
    private int amount;
    @Setter
    private int discount;
    private LocalDate creationDate;
    @Setter
    private LocalDate dateOfferExpires;
    @Setter
    private short rating;

    public Product(UUID productId, String productName, double price, CategoryName categoryName, String measurements, Color color, int amount, int discount, LocalDate dateOfferExpires) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.categoryName = categoryName;
        this.measurements = measurements;
        this.color = color;
        this.amount = amount;
        this.discount = discount;
        this.creationDate = LocalDate.now();
        this.dateOfferExpires = dateOfferExpires;
        this.rating = 0;
    }
}

