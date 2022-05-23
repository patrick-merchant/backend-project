package com.bnta.just_listen_api.controllers;

import com.bnta.just_listen_api.models.Podcast;
import com.bnta.just_listen_api.repositories.PodcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("podcasts")
public class PodcastController {

    @Autowired
    PodcastRepository podcastRepository;

    // INDEX
    @GetMapping // localhost:8080/podcasts
    public ResponseEntity<List<Podcast>> getPodcasts() {
        return new ResponseEntity<>(podcastRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}") // localhost:8080/podcasts/1 (or any other id number i.e. 2, 3 etc.)
    public ResponseEntity<Optional<Podcast>> getPodcast(@PathVariable Long id) {
        var product = podcastRepository.findById(id);
        return new ResponseEntity<>(product, product.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // CREATE
    @PostMapping // POST localhost:8080/podcasts
    public ResponseEntity<Podcast> createPodcast(@RequestBody Podcast newPodcast) {
        podcastRepository.save(newPodcast);
        return new ResponseEntity<>(newPodcast, HttpStatus.CREATED);
    }


}
