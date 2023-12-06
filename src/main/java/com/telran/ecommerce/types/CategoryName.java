package com.telran.ecommerce.types;

public enum CategoryName {
    LIVING_ROOM("living room"), KITCHEN("kitchen"), BATHROOM("bathroom");
    final String categoryName;

    CategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
