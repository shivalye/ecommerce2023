package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Product;
import com.telran.ecommerce.repository.ProductRepository;
import com.telran.ecommerce.types.CategoryName;
import com.telran.ecommerce.types.Code;
import com.telran.ecommerce.types.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ProductService implements IProduct{
    @Autowired
    ProductRepository productRepository;

    @Override
    public UUID addProduct(String productName, double price, CategoryName categoryName, String measurements, Color color, int amount, int discount, LocalDate dateOfferExpires) {
        return null;
    }

    @Override
    public Product getProduct(UUID ProductId) {
        return null;
    }

    @Override
    public Code changeAmountOfProduct(UUID productId, int amount) {
        return null;
    }

    @Override
    public Code removeProduct(UUID productId) {
        return null;
    }
}
