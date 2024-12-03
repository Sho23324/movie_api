package com.sho.MovieApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sho.MovieApi.model.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    
}
