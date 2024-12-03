package com.sho.MovieApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sho.MovieApi.model.Cast;

@Repository
public interface CastRepository extends CrudRepository<Cast, Long> {
    
}
