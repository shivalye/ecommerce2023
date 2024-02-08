package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Product;
import com.telran.ecommerce.repository.ProductJPARepository;
import com.telran.ecommerce.types.Code;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ProductService implements IProduct{
    @Autowired
    ProductJPARepository productJPARepository;

    @Override
    @Transactional
    public UUID addProduct(Product product) {
        productJPARepository.save(product);
        System.out.println(product.getCategoryName());
        return product.getProductId();
    }

    @Override
    public Product getProduct(UUID productId) {
        return productJPARepository.findById(productId).orElse(null);
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
        productJPARepository.delete(product);
        return Code.OK;
    }
    @Override
    @Transactional
    public String testProduct(){
        return "Service JPARepository test OK";
    }
}
