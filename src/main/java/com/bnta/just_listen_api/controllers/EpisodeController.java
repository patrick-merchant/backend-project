package com.bnta.just_listen_api.controllers;

import com.bnta.just_listen_api.models.Episode;
import com.bnta.just_listen_api.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("episodes")
public class EpisodeController {

    @Autowired
    private EpisodeRepository episodeRepository;

    // INDEX
    @GetMapping // localhost:8080/episodes
    public ResponseEntity<List<Episode>> getEpisodes() {
        return new ResponseEntity<>(episodeRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}") // localhost:8080/episodes/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Episode>> getEpisode(@PathVariable Long id) {
        var episode = episodeRepository.findById(id);
        return new ResponseEntity<>(episode, episode.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping // localhost:8080/episodes
    public ResponseEntity<Episode> createEpisode(@RequestBody Episode newEpisode) {
        episodeRepository.save(newEpisode);
        return new ResponseEntity<>(newEpisode, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}") // localhost:8080/episodes/1 (or any other id number instead of 1)
    public ResponseEntity<Long> deleteEpisode (@PathVariable("id") Long id) {
        episodeRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

