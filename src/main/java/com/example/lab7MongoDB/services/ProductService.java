package com.example.lab7MongoDB.services;

import com.example.lab7MongoDB.models.Competitor;
import com.example.lab7MongoDB.models.Product;
import com.example.lab7MongoDB.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findByProductIsNotNull()
                .stream()
                .map(Competitor::getProduct)
                .collect(Collectors.toList());
    }
}
