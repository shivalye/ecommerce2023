package com.telran.ecommerce.types;

public enum Role {
    USER("user"), ADMIN("admin"), MODERATOR("moderator");
    final String role;

    Role(String role) {
        this.role = role;
    }
}