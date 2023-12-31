package com.telran.ecommerce.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;
    private final String productName;
    @Setter
    private double price;
    public CategoryName categoryName;
    private final String measurements;
    public Color color;
    @Setter
    private int amount;
    @Setter
    private int discount;
    private final LocalDate creationDate;
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

enum CategoryName {
    LIVING_ROOM("living room"), KITCHEN("kitchen"), BATH_ROOM("bath room");
    final String categoryName;

    CategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}

enum Color {
    RED("red"), GREEN("green"), BLACK("black"), WHITE("white"), BROWN("brown"), YELLOW("yellow"), BLUE("blue"), ORANGE("orange");
    final String color;

    Color(String color) {
        this.color = color;
    }
}
