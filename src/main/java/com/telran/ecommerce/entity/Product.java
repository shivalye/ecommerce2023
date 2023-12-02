package com.telran.ecommerce.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;
    private String productName;
    private double price;
    private enum categoryName{LIVING_ROOM, KITCHEN, BATH_ROOM};
    private String measurements;


}
