package com.sho.MovieApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sho.MovieApi.model.Genre;
import com.sho.MovieApi.repository.GenreRepository;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Iterable<Genre> getGenreList() {
        return genreRepository.findAll();
    }

    public Genre getGenre(Long id) {
        return genreRepository.findById(id).get();
    }

    public Genre createGenre(Genre newGenre) {
        return genreRepository.save(newGenre);
    }

    public void updateGenre(Long id,Genre updatedGenre) {
        Genre genre = getGenre(id);
        updatedGenre.setId(genre.getId());
        genreRepository.save(updatedGenre);
    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
