package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.User;
import com.telran.ecommerce.types.Code;
import com.telran.ecommerce.types.Role;

import java.util.UUID;

public interface IUser {
    UUID addUser(UUID userId, String hashCode, Role role, String firstName, String lastName, String userName, String email,
                 String billingAddress, String shippingAddress);

    User getUser(UUID UserId);

    Code updateUserName(UUID userId, String firstName, String lastName, String userName);

    Code removeUser(UUID userId);
}
