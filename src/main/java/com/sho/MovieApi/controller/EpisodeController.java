package com.sho.MovieApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sho.MovieApi.model.Episode;
import com.sho.MovieApi.service.EpisodeService;

@RestController
public class EpisodeController {
    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/episodes") 
    public ResponseEntity<Iterable<Episode>> getEpisodeList() {
        return ResponseEntity.ok(episodeService.getEpisodeList());
    }

    @GetMapping("/episodes/{episodeId}")
    public ResponseEntity<Episode> getEpisode(@PathVariable Long episodeId) {
        return ResponseEntity.ok(episodeService.getEpisode(episodeId));
    }

    @PutMapping("/episodes/{episodeId}")
    public ResponseEntity<Void> upadteEpisode(@PathVariable Long episodeId, @RequestBody Episode newEpisode) {
        episodeService.updateEpisode(episodeId, newEpisode);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/episodes/{episodeId}")
    public ResponseEntity<Void> deleteEpisode(@PathVariable Long episodeId) {
        episodeService.deleteEpisode(episodeId);
        return ResponseEntity.noContent().build();
    }
}
