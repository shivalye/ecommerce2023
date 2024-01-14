package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Product;
import com.telran.ecommerce.repository.ProductRepository;
import com.telran.ecommerce.types.Code;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ProductService implements IProduct{
    @Autowired
    ProductRepository productRepository;

    @Override
    @Transactional
    public UUID addProduct(Product product) {
        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public Product getProduct(UUID productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    @Transactional
    public Code changeAmountOfProduct(UUID productId, int amount) {
        Product product = getProduct(productId);
        if (product==null){
            return Code.PRODUCT_NOT_EXIST;
        }
        product.setAmount(amount);
        return Code.OK;
    }

    @Override
    @Transactional
    public Code removeProduct(UUID productId) {
        Product product = getProduct(productId);
        if (product==null){
            return Code.PRODUCT_NOT_EXIST;
        }
        productRepository.delete(product);
        return Code.OK;
    }
}
