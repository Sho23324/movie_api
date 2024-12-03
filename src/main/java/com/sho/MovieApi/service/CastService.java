package com.sho.MovieApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sho.MovieApi.model.Cast;
import com.sho.MovieApi.repository.CastRepository;

@Service
public class CastService {
    @Autowired
    private CastRepository castRepository;

    public Iterable<Cast> getCastList() {
        return castRepository.findAll();
    }

    public Cast getCast(Long id) {
        return castRepository.findById(id).get();
    }

    public Cast createCast(Cast newCast) {
        return castRepository.save(newCast);
    }

    public void updateCast(Long id, Cast updatedCast) {
        Cast cast = getCast(id);
        updatedCast.setId(cast.getId());
        castRepository.save(updatedCast);
    }

    public void deleteCast(Long id) {
        castRepository.deleteById(id);
    }
}
