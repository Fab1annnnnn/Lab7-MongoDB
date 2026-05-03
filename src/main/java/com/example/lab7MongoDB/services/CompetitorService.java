package com.example.lab7MongoDB.services;

import com.example.lab7MongoDB.models.Competitor;
import com.example.lab7MongoDB.models.CompetitorDTO;
import com.example.lab7MongoDB.repositories.CompetitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CompetitorService {

    @Autowired
    private CompetitorRepository competitorRepository;

    public Competitor createCompetitor(CompetitorDTO dto) {
        Competitor competitor = mapDtoToEntity(dto);
        return competitorRepository.save(competitor);
    }

    public Competitor createCompetitorWithVehicle(CompetitorDTO dto) {
        Competitor competitor = mapDtoToEntity(dto);
        if (dto.getVehicle() != null) {
            dto.getVehicle().setCreatedAt(new Date());
            dto.getVehicle().setUpdatedAt(new Date());
            competitor.setVehicle(dto.getVehicle());
        }
        if (dto.getProduct() != null) {
            competitor.setProduct(dto.getProduct());
        }
        return competitorRepository.save(competitor);
    }

    public List<Competitor> getAllCompetitors() {
        return competitorRepository.findAllByOrderBySurnameAsc();
    }

    public List<Competitor> getCompetitorsByName(String name) {
        return competitorRepository.findByName(name);
    }

    public List<Competitor> getCompetitorsStartingWithA() {
        return competitorRepository.findByNameStartingWithA();
    }

    private Competitor mapDtoToEntity(CompetitorDTO dto) {
        Competitor c = new Competitor();
        c.setName(dto.getName());
        c.setSurname(dto.getSurname());
        c.setAge(dto.getAge());
        c.setTelephone(dto.getTelephone());
        c.setCellphone(dto.getCellphone());
        c.setAddress(dto.getAddress());
        c.setCity(dto.getCity());
        c.setCountry(dto.getCountry());
        c.setWinner(false);
        Date now = new Date();
        c.setCreatedAt(now);
        c.setUpdatedAt(now);
        return c;
    }
}