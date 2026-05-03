package com.example.lab7MongoDB.repositories;

import com.example.lab7MongoDB.models.Competitor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface CompetitorRepository extends MongoRepository<Competitor, String> {
    List<Competitor> findByName(String name);

    List<Competitor> findAllByOrderBySurnameAsc();

    @Query("{ 'name': { $regex: '^A', $options: 'i' } }")
    List<Competitor> findByNameStartingWithA();
}