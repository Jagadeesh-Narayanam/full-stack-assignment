package com.springframework.fullstackapplication.respositories;

import com.springframework.fullstackapplication.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
