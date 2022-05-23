package com.bnta.just_listen_api.controllers;

import com.bnta.just_listen_api.models.Episode;
import com.bnta.just_listen_api.repositories.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("episodes")
public class EpisodeController {

    @Autowired
    private EpisodeRepository episodeRepository;

    // INDEX
    @GetMapping
    public ResponseEntity<List<Episode>> getEpisodes() {
        return new ResponseEntity<>(episodeRepository.findAll(), HttpStatus.OK);
    }

    
}

