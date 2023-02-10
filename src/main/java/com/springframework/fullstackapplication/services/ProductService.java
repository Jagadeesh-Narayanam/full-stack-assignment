package com.springframework.fullstackapplication.services;

import com.springframework.fullstackapplication.model.Product;
import com.springframework.fullstackapplication.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> addProductsList(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
