package com.sho.MovieApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sho.MovieApi.model.Production;
import com.sho.MovieApi.repository.ProductionRepository;

@Service
public class ProductionService {
    @Autowired
    private ProductionRepository productionRepository;

    public Iterable<Production> getProductionList() {
        return productionRepository.findAll();
    }

    public Production getProduction(Long id) {
        return productionRepository.findById(id).get();
    }

    public Production createProduction(Production newProduction) {
        return productionRepository.save(newProduction);
    }

    public void updateProduction(Long id, Production updatedProduction) {
        Production production = getProduction(id);
        updatedProduction.setId(production.getId());
        productionRepository.save(updatedProduction);
    }

    public void deleteProduction(Long id) {
        productionRepository.deleteById(id);
    }
}
