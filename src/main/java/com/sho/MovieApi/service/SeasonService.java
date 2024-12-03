package com.sho.MovieApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sho.MovieApi.model.Season;
import com.sho.MovieApi.model.Series;
import com.sho.MovieApi.repository.SeasonRepository;

@Service
public class SeasonService {
    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SeriesService seriesService;

    public Iterable<Season> getSeasonList() {
        return seasonRepository.findAll();
    }

    public Season getSeason(Long id) {
        return seasonRepository.findById(id).get();
    }

    public Season createSeason(Long seriesId, Season newSeason) {
        Series series = seriesService.getSeries(seriesId);
        newSeason.setSeries(series);
        return seasonRepository.save(newSeason);
    }

    public void updateSeason(Long id, Season updatedSeason) {
        Season season = getSeason(id);
        updatedSeason.setId(season.getId());
        seasonRepository.save(updatedSeason);
    }

    public void deleteSeason(Long id) {
        seasonRepository.deleteById(id);
    }
}
