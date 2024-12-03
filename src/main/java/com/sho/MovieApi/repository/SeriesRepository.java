package com.sho.MovieApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sho.MovieApi.model.Series;

@Repository
public interface SeriesRepository extends CrudRepository<Series, Long> {
    Iterable<Series> findByTitleContaining(String title);
}
