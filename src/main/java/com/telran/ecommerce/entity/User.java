package com.telran.ecommerce.entity;

import jakarta.persistence.Entity;

import java.util.UUID;
@Entity
public class User {
    private UUID userId;
    private String password;
    private Role role;
    private String firstName;
    private String lastName;
    private String displayName;
    private String email;
    private Address billingAddress;
    private Address shippingAddress;


    public User(String password, Role role, String firstName, String lastName, String displayName,
                String email, Address billingAddress, Address shippingAddress) {
        this.userId = UUID.randomUUID();
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.email = email;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public void updateUserInfo(String password, String email, String firstName, String lastName,
                               Address billingAddress, Address shippingAddress) {
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        // Также можно добавить другие поля, которые требуется обновить
    }

    // Метод для удаления пользователя из системы
    public void removeUser() {
        // TODO
    }

    // Метод для сброса пароля пользователя
    public void resetPassword(String newPassword) {
        this.password = newPassword;
    }

}