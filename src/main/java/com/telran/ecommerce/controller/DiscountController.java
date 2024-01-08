package com.telran.ecommerce.controller;

import com.telran.ecommerce.service.IDiscount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    private final IDiscount discountService;

    public DiscountController(IDiscount discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/check")
    public ResponseEntity<Double> checkDiscount(@RequestBody String enteredCode) {
        Double discountAmount = discountService.checkDiscount(enteredCode);
        return ResponseEntity.ok(discountAmount);
    }
}
