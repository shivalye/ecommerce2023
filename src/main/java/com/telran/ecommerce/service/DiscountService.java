package com.telran.ecommerce.service;

import com.telran.ecommerce.types.DiscountCode;
import org.springframework.stereotype.Service;

@Service
public class DiscountService implements IDiscount {

    @Override
    public Double checkDiscount(String enteredCode) {
        try {
            DiscountCode code = DiscountCode.valueOf(enteredCode);
            switch (code) {
                case BONUS5:
                    return 5.0;
                case BONUS10:
                    return 10.0;
                case BONUS15:
                    return 15.0;
                case BONUS20:
                    return 20.0;
                default:
                    return 0.0;
            }
        } catch (IllegalArgumentException e) {
            return 0.0; // Если введенный код не соответствует ни одному из DiscountCode
        }
    }
}
