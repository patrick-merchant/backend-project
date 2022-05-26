package com.bnta.just_listen_api.services;

import com.bnta.just_listen_api.models.Episode;
import com.bnta.just_listen_api.repositories.EpisodeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EpisodeService {

    private EpisodeRepository episodeRepository;

    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    public Optional<Episode> findById(Long id){
        return episodeRepository.findById(id);
    }
}
