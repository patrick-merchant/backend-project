package com.bnta.just_listen_api.controllers;

import com.bnta.just_listen_api.models.Podcast;
import com.bnta.just_listen_api.repositories.PodcastRepository;
import com.bnta.just_listen_api.services.PodcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("podcasts")
public class PodcastController {

    @Autowired
    private PodcastRepository podcastRepository;

    @Autowired
    private PodcastService podcastService;


    // INDEX AND MULTIPLE FILTERS
    @GetMapping
    public ResponseEntity<List<Podcast>> getAllPodcastsAndFilters(
            @RequestParam Map<String, String> requestParams, Float rating
    ) {
        String title = requestParams.get("title");
        String description = requestParams.get("description");
        String category = requestParams.get("category");
        String sources = requestParams.get("sources");
        if (title != null) {
            return new ResponseEntity<>(podcastRepository.findPodcastByTitleContainingIgnoreCase(title),
                    HttpStatus.OK);
        } else if (description != null) {
            return new ResponseEntity<>(podcastRepository.findPodcastByDescriptionContainingIgnoreCase(description),
                    HttpStatus.OK);
        } else if (category != null) {
            return new ResponseEntity<>(podcastRepository.findPodcastByCategoryContainingIgnoreCase(category),
                    HttpStatus.OK);
        } else if (rating != null) {
            return new ResponseEntity<>(podcastRepository.findPodcastByRatingGreaterThan(rating),
                    HttpStatus.OK);
        } else if (sources != null) {
            return new ResponseEntity<>(podcastRepository.findPodcastBySourcesContainingIgnoreCase(sources),
                    HttpStatus.OK);
        } else
            return new ResponseEntity<>(podcastRepository.findAll(),
                    HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}") // localhost:8080/podcasts/1 (or any other id number i.e. 2, 3 etc.)
    public ResponseEntity<Optional<Podcast>> getPodcast(@PathVariable Long id) {
        var podcast = podcastRepository.findById(id);
        return new ResponseEntity<>(podcast, podcast.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //UPDATE
    @PutMapping(value = "/{id}") // localhost:8080/podcasts/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Podcast>> putPodcast(@RequestBody Podcast podcast, @PathVariable Long id) {
        if (podcastRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(podcastRepository.findById(id), HttpStatus.NOT_FOUND);
        } else {
            Podcast podcastToUpdate = podcastRepository.findById(id).get();
            podcastToUpdate.setTitle(podcast.getTitle());
            podcastToUpdate.setContentNote(podcast.getContentNote());
            podcastToUpdate.setDescription(podcast.getDescription());
            podcastToUpdate.setCategory(podcast.getCategory());
            podcastToUpdate.setRating(podcast.getRating());
            podcastToUpdate.setSources(podcast.getSources());
            podcastRepository.save(podcastToUpdate);
            return new ResponseEntity<>(podcastRepository.findById(id), HttpStatus.OK);
        }
    }

    // POST
    @PostMapping // localhost:8080/podcasts
    public ResponseEntity<Podcast> createPodcast(@RequestBody Podcast newPodcast) {
        podcastRepository.save(newPodcast);
        return new ResponseEntity<>(newPodcast, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}") // localhost:8080/podcasts/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Podcast>> deletePodcast(@PathVariable Long id) {
        var podcast = podcastRepository.findById(id);
        if (podcast.isEmpty()) {
            return new ResponseEntity<>(podcast, HttpStatus.NOT_FOUND);
        } else {
            podcastRepository.deleteById(id);
            return new ResponseEntity(podcastRepository.findAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/getrec")
    public ResponseEntity<Optional<Podcast>> giveUserAPodcastRec() throws Exception {
        return new ResponseEntity(podcastService.getRandomRecommendation(), HttpStatus.OK);
    }
}