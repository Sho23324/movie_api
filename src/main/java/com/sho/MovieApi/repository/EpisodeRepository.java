package com.sho.MovieApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sho.MovieApi.model.Episode;

@Repository
public interface EpisodeRepository extends CrudRepository<Episode, Long> {
    
}
