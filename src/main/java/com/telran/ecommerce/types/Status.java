package com.telran.ecommerce.types;

public enum Status {
    PENDING("Pending"), CONFIRMED("Confirmed"), PROCESSING("Processing"), COMPLETED("Completed"), CANCELLED("Cancelled"), DELIVERED("Delivered"), RETURNED("Returned");
    final String status;

    Status(String status) {
        this.status = status;
    }
}
