package com.bnta.just_listen_api.controllers;


import com.bnta.just_listen_api.models.Contributor;
import com.bnta.just_listen_api.repositories.ContributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contributors") //localhost:8080/contributors

public class ContributorController {

    @Autowired
    ContributorRepository contributorRepository;

    //INDEX
    @GetMapping
    public ResponseEntity<List<Contributor>> getContributors() {
        return new ResponseEntity<>(contributorRepository.findAll(), HttpStatus.OK);

    }
    //SHOW
    @GetMapping(value ="/{id}")

    public ResponseEntity<Optional<Contributor>>getContributor(@PathVariable Long id) {
        return new ResponseEntity<>(contributorRepository.findById(id),HttpStatus.OK);

    }

    //POST
    @PostMapping
    public ResponseEntity<Contributor> createContributor(@RequestBody Contributor newContributor){
        contributorRepository.save(newContributor);
        return  new ResponseEntity<>(newContributor, HttpStatus.CREATED);

    }

}
