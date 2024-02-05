package com.telran.ecommerce.controller;

import com.telran.ecommerce.entity.Product;
import com.telran.ecommerce.service.ProductService;
import com.telran.ecommerce.types.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.telran.ecommerce.constants.ApiConstants.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = ADD_PRODUCT)
    public UUID addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping(value = GET_PRODUCT)
    public Product getProduct(@RequestParam(name = "product_id") UUID productId) {
        return productService.getProduct(productId);
    }

    @PutMapping(value = CHANGE_AMOUNT_OF_PRODUCT)
    public Code changeAmountOfProduct(@RequestParam(name = "product_id") UUID productId, @RequestParam(name = "amount") int amount) {
        return productService.changeAmountOfProduct(productId, amount);
    }

    @DeleteMapping(value = REMOVE_PRODUCT)
    public Code removeProduct(@RequestParam(name = "product_id") UUID productId) {
        return productService.removeProduct(productId);
    }

    @GetMapping(value = TEST)
    public String getTest(){
//        String text = "Test passed successfully";
        return productService.testProduct();
    }
}
