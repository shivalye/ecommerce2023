package com.telran.ecommerce.types;

public enum Status {
    PREPARED_TO_DELIVERY("prepared to delivery"), AT_LOCAL_DELIVERY_COMPANY("at local delivery company"), DELIVERED("delivered"), FINISHED("finished");
    final String status;

    Status(String status) {
        this.status = status;
    }
}
