package com.example.lab7MongoDB.repositories;

import com.example.lab7MongoDB.models.Competitor;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProductRepository extends MongoRepository<Competitor, String> {
    List<Competitor> findByProductIsNotNull();
}