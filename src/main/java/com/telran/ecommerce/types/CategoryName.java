package com.telran.ecommerce.types;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CategoryName {
    LIVING_ROOM("living room"), KITCHEN("kitchen"), BATHROOM("bathroom");
    private final String category;

    CategoryName(String category) {
        this.category = category;
    }
}
