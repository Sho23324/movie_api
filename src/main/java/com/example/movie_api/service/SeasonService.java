package com.example.movie_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movie_api.model.Season;
import com.example.movie_api.repository.SeasonRepository;

@Service
public class SeasonService {
    @Autowired
    private SeasonRepository seasonRepository;

    public Season createSeason(Season season) {
        return seasonRepository.save(season);
    }

    public Season getSeason(Long seasonId) {
        return seasonRepository.findById(seasonId).get();
    }

    public Iterable<Season> getSeasonList() {
        return seasonRepository.findAll();
    }

    public void updateSeason(Long seasonId, Season newSeason) {
        Season season = getSeason(seasonId);
        newSeason.setId(season.getId());
        seasonRepository.save(newSeason);
    }

    public void deleteSeason(Long seasonId) {
        seasonRepository.deleteById(seasonId);
    }
}
