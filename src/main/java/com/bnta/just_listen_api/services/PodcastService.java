package com.bnta.just_listen_api.services;

import com.bnta.just_listen_api.models.Podcast;
import com.bnta.just_listen_api.repositories.PodcastRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PodcastService {

    private PodcastRepository podcastRepository;

    public PodcastService(PodcastRepository podcastRepository) {
        this.podcastRepository = podcastRepository;
    }

    public Optional<Podcast> getRandomRecommendation() {
        List<Podcast> allPodcasts = podcastRepository.findAll();
        int randomId = new Random().nextInt(allPodcasts.size() + 1);
        while (randomId == 0) {
            randomId = new Random().nextInt(allPodcasts.size() + 1);
        }
        return podcastRepository.findById((long) randomId);
    }

    public List<Podcast> findAll() {
        return podcastRepository.findAll();
    }

    public Optional<Podcast> findById(Long id) {
        return podcastRepository.findById(id);
    }
}
