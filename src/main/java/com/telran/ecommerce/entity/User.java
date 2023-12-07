package com.telran.ecommerce.entity;

import com.telran.ecommerce.types.Role;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID userId;
    @Setter
    private String hashCode;
    @Setter
    private Role role;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String userName;
    @Setter
    private String email;
    @Setter
    private String billingAddress;
    @Setter
    private String shippingAddress;

    public User(UUID userId, String hashCode, Role role, String firstName, String lastName, String userName,
                String email, String billingAddress, String shippingAddress) {
        this.userId = userId;
        this.hashCode = hashCode;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }
}