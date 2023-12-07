package com.telran.ecommerce.service;

import com.telran.ecommerce.entity.Category;

public interface ICategory {
    String addCategory(String categoryName);

    Category getCategory(String categoryName);

    String removeCategory(String categoryName);
}
