package com.telran.ecommerce.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
@ToString
@EqualsAndHashCode
public class Category {
    @Id
    private String categoryName;
    @Setter
    private List<String> productsId;

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.productsId = new ArrayList<>();
    }
}
