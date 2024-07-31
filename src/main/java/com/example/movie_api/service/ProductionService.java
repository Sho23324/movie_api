package com.example.movie_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_api.model.Production;
import com.example.movie_api.repository.ProductionRepository;

@Service
public class ProductionService {
    @Autowired
    private ProductionRepository productionRepository;

    public Production createProduction(Production production) {
        return productionRepository.save(production);
    }

    public Production getProduction(Long productionId) {
        return productionRepository.findById(productionId).get();
    }

    public Iterable<Production> getProductionList() {
        return productionRepository.findAll();
    }

    public void updateProduction(Long productionId, Production newProduction) {
        Production production = getProduction(productionId);
        newProduction.setId(production.getId());
        productionRepository.save(newProduction);
    }

    public void deleteProduction(Long productionId) {
        productionRepository.deleteById(productionId);
    }
}
