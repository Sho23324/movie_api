package com.sho.MovieApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sho.MovieApi.model.Episode;
import com.sho.MovieApi.repository.EpisodeRepository;

@Service
public class EpisodeService {
    @Autowired
    private EpisodeRepository episodeRepository;

    public Iterable<Episode> getEpisodeList() {
        return episodeRepository.findAll();
    }

    public Episode getEpisode(Long id) {
        return episodeRepository.findById(id).get();
    }

    public Episode createEpisode(Episode newEpisode) {
        return episodeRepository.save(newEpisode);
    }

    public void updateEpisode(Long episodeId, Episode updatedEpisode) {
        Episode oldEpisode = getEpisode(episodeId);
        if(updatedEpisode.getSeason() == null) {
            updatedEpisode.setSeason(oldEpisode.getSeason());
        }
        updatedEpisode.setId(oldEpisode.getId());
        episodeRepository.save(updatedEpisode);
    }

    public void deleteEpisode(Long episodeId) {
        episodeRepository.deleteById(episodeId);
    }
}
