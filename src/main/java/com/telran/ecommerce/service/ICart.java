package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Cart;
import com.telran.ecommerce.types.Code;
import com.telran.ecommerce.types.Shipping;

import java.util.LinkedHashMap;
import java.util.UUID;

public interface ICart {
    UUID addCart(UUID cartId, UUID userId, LinkedHashMap<UUID, Integer> products, Shipping shipping);

    Cart getCart(UUID cartId);

    Code addRemoveProductToCart(UUID cartId, UUID productId, int amount);

    Code removeCart(UUID cartId);
}
