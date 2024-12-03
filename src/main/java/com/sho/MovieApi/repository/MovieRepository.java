package com.sho.MovieApi.repository;


import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sho.MovieApi.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
    Movie findBySlug(String slug);
    Iterable<Movie> findByTitleContaining(String title);
    
}
