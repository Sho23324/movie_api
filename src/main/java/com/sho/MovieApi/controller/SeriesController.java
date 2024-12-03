package com.sho.MovieApi.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sho.MovieApi.model.Series;
import com.sho.MovieApi.service.SeriesService;

@RestController
public class SeriesController {
    @Autowired
    private SeriesService seriesService;

    @GetMapping("/series")
    public ResponseEntity<Iterable<Series>> getSeries() {
        return ResponseEntity.ok(seriesService.getSeriesList());
    }

    @GetMapping("/series/{seriesId}")
    public ResponseEntity<Series> getSeries(@PathVariable Long seriesId) {
        return ResponseEntity.ok(seriesService.getSeries(seriesId));
    }

    @PostMapping("/series")
    public ResponseEntity<Void> createSeries(@RequestBody Series newSeries) {
        Series createdSeries = seriesService.createSeries(newSeries);
        URI created_series_location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{resourceId}")
                .buildAndExpand(createdSeries.getId())
                .toUri();
        return ResponseEntity.created(created_series_location).build();
    } 

    @PutMapping("/series/{seriesId}")
    public ResponseEntity<Void> updateSeries(@PathVariable Long seriesId, @RequestBody Series updatedSeries) {
        Series series = seriesService.getSeries(seriesId);
        updatedSeries.setId(series.getId());
        seriesService.updateSeries(seriesId, updatedSeries);
        return ResponseEntity.noContent().build();
    }
}
