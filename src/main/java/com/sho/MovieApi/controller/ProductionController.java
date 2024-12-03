package com.sho.MovieApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sho.MovieApi.model.Production;
import com.sho.MovieApi.service.ProductionService;

@RestController
public class ProductionController {
    @Autowired
    private ProductionService productionService;

    @GetMapping("/productions")
    public ResponseEntity<Iterable<Production>> getProductionList() {
        return ResponseEntity.ok(productionService.getProductionList());
    }

    @GetMapping("/productions/{productionId}") 
    public ResponseEntity<Production> getProduction(@PathVariable Long productionId) {
        return ResponseEntity.ok(productionService.getProduction(productionId));
    }

    @DeleteMapping("/productions/{productionId}")
    public ResponseEntity<Void> deleteProduction(@PathVariable Long productionId) {
        productionService.deleteProduction(productionId);
        return ResponseEntity.noContent().build();
    }
}
