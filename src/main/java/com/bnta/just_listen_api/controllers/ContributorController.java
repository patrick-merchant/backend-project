package com.bnta.just_listen_api.controllers;


import com.bnta.just_listen_api.models.Contributor;
import com.bnta.just_listen_api.models.Episode;
import com.bnta.just_listen_api.repositories.ContributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("contributors") //localhost:8080/contributors

public class ContributorController {

    @Autowired
    private ContributorRepository contributorRepository;

    // INDEX
    @GetMapping // localhost:8080/contributors
    public ResponseEntity<List<Contributor>> getContributors() {
        return new ResponseEntity<>(contributorRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value ="/{id}") // localhost:8080/contributors/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Contributor>> getContributor(@PathVariable Long id) {
        var contributor =  contributorRepository.findById(id);
        return new ResponseEntity<>(contributor, contributor.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    // POST
    @PostMapping // localhost:8080/contributors
    public ResponseEntity<Contributor> createContributor(@RequestBody Contributor newContributor){
        contributorRepository.save(newContributor);
        return  new ResponseEntity<>(newContributor, HttpStatus.CREATED);
    }

    // DELETE
    @DeleteMapping("/{id}") // localhost:8080/contributors/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Contributor>> deleteContributor(@PathVariable Long id) {
        var contributor = contributorRepository.findById(id);
        contributorRepository.deleteById(id);
        return new ResponseEntity(contributorRepository.findAll(), contributor.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    } // ToDo: need to test

}
