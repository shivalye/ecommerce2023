package com.telran.ecommerce.repository;

import com.telran.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface ProductJPARepository extends JpaRepository<Product, UUID> {
}
