package com.sho.MovieApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sho.MovieApi.model.Movie;
import com.sho.MovieApi.repository.MovieRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Iterable<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).get();
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void updateMovie(Long movieId, Movie updateMovie) {
        Movie movie = movieRepository.findById(movieId).get();
        updateMovie.setId(movie.getId());
        movieRepository.save(updateMovie);
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
