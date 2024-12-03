package com.sho.MovieApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sho.MovieApi.model.Season;
import com.sho.MovieApi.service.SeasonService;

@RestController
public class SeasonController {
    @Autowired
    private SeasonService seasonService;

    @GetMapping("/seasons")
    public ResponseEntity<Iterable<Season>> getSeasonList() {
        return ResponseEntity.ok(seasonService.getSeasonList());
    }

    @GetMapping("/seasons/{seasonId}")
    public ResponseEntity<Season> getSeason(@PathVariable Long seasonId) {
        return ResponseEntity.ok(seasonService.getSeason(seasonId));
    }

    // @PostMapping("/seasons")
    // public ResponseEntity<Void> createSeason(@RequestBody Season season) {
    //     seasonService.createSeason(null, season);
    // }

    @PutMapping("/seasons/{seasonId}")
    public ResponseEntity<Void> updateSeason(@PathVariable Long seasonId, @RequestBody Season newSeason) {
        seasonService.updateSeason(seasonId, newSeason);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/seasons/{seasonId}")
    public ResponseEntity<Void> deleteSeason(Long seasonId) {
        seasonService.deleteSeason(seasonId);
        return ResponseEntity.noContent().build();
    }
}
