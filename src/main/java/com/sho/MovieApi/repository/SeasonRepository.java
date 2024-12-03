package com.sho.MovieApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sho.MovieApi.model.Season;
@Repository
public interface SeasonRepository extends CrudRepository<Season, Long>{
    
}
