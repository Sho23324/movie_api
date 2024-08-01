package com.example.movie_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_api.model.Movie;
import com.example.movie_api.repository.MovieRepository;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public Iterable<Movie> getMovieList() {
        return movieRepository.findAll();
    }
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).get();
    }


    public void updateMovie(Long movieId, Movie newMovie) {
        Movie movie = getMovie(movieId);
        newMovie.setId(movie.getId());
        movieRepository.save(newMovie);
    }

    public void deleteMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
