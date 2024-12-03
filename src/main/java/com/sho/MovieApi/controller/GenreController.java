package com.sho.MovieApi.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sho.MovieApi.model.Genre;
import com.sho.MovieApi.service.GenreService;

@RestController
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public ResponseEntity<Iterable<Genre>> getGenreList() {
        return ResponseEntity.ok(genreService.getGenreList());
    }

    @GetMapping("/genres/{genreId}")
    public ResponseEntity<Genre> getGenre(@PathVariable Long genreId) {
        return ResponseEntity.ok(genreService.getGenre(genreId));
    }

    @PostMapping("/genres")
    public ResponseEntity<Void> createGenre(@RequestBody Genre newGenre) {
        Genre createdGenre = genreService.createGenre(newGenre);
        URI new_genre_location = ServletUriComponentsBuilder
        .fromCurrentRequestUri()
        .path("/{resourceId}")
        .buildAndExpand(createdGenre.getId())
        .toUri();
        return ResponseEntity.created(new_genre_location).build();
    }

    @PutMapping("/genres/{genreId}")
    public ResponseEntity<Void> updateGenre(@PathVariable Long genreId, @RequestBody Genre updatedGenre) {
        genreService.updateGenre(genreId, updatedGenre);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/genres/{genreId}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long genreId) {
        genreService.deleteGenre(genreId);
        return ResponseEntity.noContent().build();
    }
}
