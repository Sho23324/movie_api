package com.sho.MovieApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sho.MovieApi.model.Movie;
import com.sho.MovieApi.service.MovieService;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<Iterable<Movie>> getMovieList() {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping("movies/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long movieId) {
        Movie movie = movieService.getMovie(movieId);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.noContent().build();
    }

}
