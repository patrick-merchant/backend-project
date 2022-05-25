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

//    // INDEX - Old version
//    @GetMapping // localhost:8080/contributors
//    public ResponseEntity<List<Contributor>> getContributors() {
//        return new ResponseEntity<>(contributorRepository.findAll(), HttpStatus.OK);
//    }

    // INDEX AND FILTERS
    @GetMapping
    public ResponseEntity<List<Contributor>> getAllContributorsAndFilters(
            @RequestParam(required = false, name = "name") String name
    ){
        if(name != null){
            return new ResponseEntity<>(contributorRepository.findContributorByNameContainingIgnoreCase(name),
                    HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(contributorRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping(value ="/{id}") // localhost:8080/contributors/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Contributor>> getContributor(@PathVariable Long id) {
        var contributor =  contributorRepository.findById(id);
        return new ResponseEntity<>(contributor, contributor.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //UPDATE
    @PutMapping(value="/{id}") // localhost:8080/contributors/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<Contributor>> putContributor(@RequestBody Contributor contributor, @PathVariable Long id){
        if(contributorRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(contributorRepository.findById(id), HttpStatus.NOT_FOUND);
        } else {
            Contributor contributorToUpdate = contributorRepository.findById(id).get();
            contributorToUpdate.setName(contributor.getName());
            contributorToUpdate.setProfession(contributor.getProfession());
            contributorToUpdate.setPresenter(contributor.isPresenter());
            contributorRepository.save(contributorToUpdate);
            return new ResponseEntity<>(contributorRepository.findById(id), HttpStatus.OK);
        }
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
