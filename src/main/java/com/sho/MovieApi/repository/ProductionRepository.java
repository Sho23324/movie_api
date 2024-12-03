package com.sho.MovieApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sho.MovieApi.model.Production;

@Repository
public interface ProductionRepository extends CrudRepository<Production, Long>{
    
}
