package com.example.lab7MongoDB.controllers;

import com.example.lab7MongoDB.models.Competitor;
import com.example.lab7MongoDB.models.CompetitorDTO;
import com.example.lab7MongoDB.services.CompetitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/competitors")
@CrossOrigin(origins = "*")
public class CompetitorController {

    @Autowired
    private CompetitorService competitorService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> createCompetitor(@RequestBody CompetitorDTO dto) {
        Competitor saved = competitorService.createCompetitor(dto);
        Map<String, String> response = new HashMap<>();
        response.put("competitor_id", saved.getId());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add/vehicle")
    public ResponseEntity<Map<String, String>> createCompetitorWithVehicle(@RequestBody CompetitorDTO dto) {
        Competitor saved = competitorService.createCompetitorWithVehicle(dto);
        Map<String, String> response = new HashMap<>();
        response.put("competitor_id", saved.getId());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Competitor>> getAll() {
        return ResponseEntity.ok(competitorService.getAllCompetitors());
    }

    @GetMapping("/search/startWithA")
    public ResponseEntity<List<Competitor>> getStartingWithA() {
        return ResponseEntity.ok(competitorService.getCompetitorsStartingWithA());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Competitor>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(competitorService.getCompetitorsByName(name));
    }
}