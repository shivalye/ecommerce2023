package com.telran.ecommerce.types;

import java.io.Serializable;

public enum CategoryName {
    LIVING_ROOM("living room"), KITCHEN("kitchen"), BATHROOM("bathroom");
    final String categoryName;

    CategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
