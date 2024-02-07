package com.telran.ecommerce.service;

import com.telran.ecommerce.types.CategoryName;
import com.telran.ecommerce.types.Code;
import com.telran.ecommerce.types.Color;
import com.telran.ecommerce.entity.Product;

import java.time.LocalDate;
import java.util.UUID;

public interface IProduct {
    UUID addProduct(Product product);

    Product getProduct(UUID productId);

    Code changeAmountOfProduct(UUID productId, int amount);

    Code removeProduct(UUID productId);
    String testProduct();
}
