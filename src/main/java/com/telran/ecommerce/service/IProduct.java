package com.telran.ecommerce.service;

import com.telran.ecommerce.types.CategoryName;
import com.telran.ecommerce.types.Code;
import com.telran.ecommerce.types.Color;
import com.telran.ecommerce.entity.Product;

import java.time.LocalDate;
import java.util.UUID;

public interface IProduct {
    UUID addProduct(String productName, double price, CategoryName categoryName, String measurements,
                    Color color, int amount, int discount, LocalDate dateOfferExpires);

    Product getProduct(UUID ProductId);

    Code changeAmountOfProduct(UUID productId, int amount);

    Code removeProduct(UUID productId);
}
