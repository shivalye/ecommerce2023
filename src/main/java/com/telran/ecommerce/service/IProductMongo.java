package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Product;
import com.telran.ecommerce.types.Code;

import java.util.UUID;

public interface IProductMongo {
    UUID addProduct(Product product);

    Product getProduct(UUID productId);

    Code changeAmountOfProduct(UUID productId, int amount);

    Code removeProduct(UUID productId);

    String testProduct();
}
