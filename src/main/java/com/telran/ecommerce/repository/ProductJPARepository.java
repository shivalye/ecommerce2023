package com.telran.ecommerce.repository;

import com.telran.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;
@Repository
public interface ProductJPARepository extends JpaRepository<Product, UUID> {
}
