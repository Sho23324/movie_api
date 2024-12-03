package com.sho.MovieApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sho.MovieApi.model.Series;
import com.sho.MovieApi.repository.SeriesRepository;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;

    public Iterable<Series> getSeriesList() {
        return seriesRepository.findAll();
    }

    public Series getSeries(Long id) {
        return seriesRepository.findById(id).get();
    }

    public Series createSeries(Series newSeries) {
        return seriesRepository.save(newSeries);
    }

    public void updateSeries(Long id, Series updatedSeries) {
        Series series = getSeries(id);
        updatedSeries.setId(series.getId());
        seriesRepository.save(updatedSeries);
    }

    public void deleteSeries(Long id) {
        seriesRepository.deleteById(id);
    }
}
