package com.bnta.just_listen_api.controllers;

import com.bnta.just_listen_api.models.Episode;
import com.bnta.just_listen_api.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("episodes")
public class EpisodeController {

    @Autowired
    private EpisodeRepository episodeRepository;

    // INDEX AND MULTIPLE FILTERS
    @GetMapping
    public ResponseEntity<List<Episode>> getAllEpisodesAndFilters(
            @RequestParam Map<String, String> requestParams, Integer durationLessThan, LocalDate dateposted
    ) {
        String name = requestParams.get("name");
        String description = requestParams.get("description");
        String contributorName = requestParams.get("contributorName");
        if (name != null) {
            return new ResponseEntity<>(episodeRepository.findEpisodeByNameContainingIgnoreCase(name),
                    episodeRepository.findEpisodeByNameContainingIgnoreCase(name).isEmpty() ?
                            HttpStatus.NOT_FOUND :
                            HttpStatus.OK);
        } else if (description != null) {
            return new ResponseEntity<>(episodeRepository.findEpisodeByDescriptionContainingIgnoreCase(description),
                    episodeRepository.findEpisodeByDescriptionContainingIgnoreCase(description).isEmpty() ?
                            HttpStatus.NOT_FOUND :
                            HttpStatus.OK);
        } else if (durationLessThan != null) {
            return new ResponseEntity<>(episodeRepository.findEpisodeByDurationLessThan(durationLessThan),
                    episodeRepository.findEpisodeByDurationLessThan(durationLessThan).isEmpty() ?
                            HttpStatus.NOT_FOUND :
                            HttpStatus.OK);
        } else if (contributorName != null) {
            return new ResponseEntity<>(episodeRepository.findEpisodeByContributorsNameContainingIgnoreCase(contributorName),
                    episodeRepository.findEpisodeByContributorsNameContainingIgnoreCase(contributorName).isEmpty() ?
                            HttpStatus.NOT_FOUND :
                            HttpStatus.OK);
        } else
            return new ResponseEntity<>(episodeRepository.findAll(),
                    episodeRepository.findAll().isEmpty() ?
                            HttpStatus.NOT_FOUND :
                            HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}") // localhost:8080/episodes/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Episode>> getEpisode(@PathVariable Long id) {
        var episode = episodeRepository.findById(id);
        return new ResponseEntity<>(episode, episode.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //UPDATE
    @PutMapping(value = "/{id}") // localhost:8080/episodes/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Episode>> putEpisode(@RequestBody Episode episode, @PathVariable Long id) {
        if (episodeRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(episodeRepository.findById(id), HttpStatus.NOT_FOUND);
        } else {
            Episode episodeToUpdate = episodeRepository.findById(id).get();
            episodeToUpdate.setName(episode.getName());
            episodeToUpdate.setDescription(episode.getDescription());
            episodeToUpdate.setDuration(episode.getDuration());
            episodeToUpdate.setDatePosted(episode.getDatePosted());
            episodeToUpdate.setPodcast(episode.getPodcast());
            episodeToUpdate.setContributors(episode.getContributors());
            episodeRepository.save(episodeToUpdate);
            return new ResponseEntity<>(episodeRepository.findById(id), HttpStatus.OK);
        }
    }

    // POST
    @PostMapping // localhost:8080/episodes
    public ResponseEntity<Episode> createEpisode(@RequestBody Episode newEpisode) {
        episodeRepository.save(newEpisode);
        return new ResponseEntity<>(newEpisode, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}") // localhost:8080/episodes/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Episode>> deleteEpisode(@PathVariable Long id) {
        var episode = episodeRepository.findById(id);
        if (episode.isEmpty()) {
            return new ResponseEntity<>(episode, HttpStatus.NOT_FOUND);
        } else {
            episodeRepository.deleteById(id);
            return new ResponseEntity(episodeRepository.findAll(), HttpStatus.OK);
        }
    }

}

