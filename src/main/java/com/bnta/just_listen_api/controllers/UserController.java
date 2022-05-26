package com.bnta.just_listen_api.controllers;

import com.bnta.just_listen_api.models.Podcast;
import com.bnta.just_listen_api.models.User;
import com.bnta.just_listen_api.repositories.UserRepository;
import com.bnta.just_listen_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // INDEX
    @GetMapping // localhost:8080/users
    public ResponseEntity<List<Podcast>> getPodcasts() {
        return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
    }

    // SHOW
    @GetMapping("/{id}") // localhost:8080/users/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        var episode = userRepository.findById(id);
        return new ResponseEntity<>(episode, episode.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //UPDATE
    @PutMapping(value = "/{id}") // localhost:8080/users/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<User>> putUser(@RequestBody User user, @PathVariable Long id) {
        if (userRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(userRepository.findById(id), HttpStatus.NOT_FOUND);
        } else {
            User userToUpdate = userRepository.findById(id).get();
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setAdmin(user.getAdmin());
            userRepository.save(userToUpdate);
            return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
        }
    }

    // POST
    @PostMapping // localhost:8080/users
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    // DELETE
    @DeleteMapping("/{id}") // localhost:8080/users/1 (or any other id number instead of 1)
    public ResponseEntity<Optional<User>> deleteUser(@PathVariable Long id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        } else {
            userRepository.deleteById(id);
            return new ResponseEntity(userRepository.findAll(), HttpStatus.OK);
        }
    }


    @PostMapping("/getrec/{id}")
    public void giveUserAPodcastRec(@PathVariable Long id) throws Exception {
        userService.giveUser3Recs(id);
    }

    @DeleteMapping("/deleterec/{userid}/{podcastid}")
    public void deleteRec(@PathVariable Long userid, @PathVariable Long podcastid) {
        userService.deleteUsersRec(userid, podcastid);
    }

    @PostMapping("/replacerec/{userid}/{podcastid}")
    public void replacePodcastRec(@PathVariable Long userid, @PathVariable Long podcastid) throws Exception {
        userService.replacePodcastRec(userid, podcastid);
    }

    @PostMapping("/addwatched/{userid}/{episodeid}")
    public void addWatchedEpisodeToUserWatchedList(@PathVariable Long userid, @PathVariable Long episodeid) throws Exception {
        userService.addWatchedEpisodeToUserWatchedList(userid, episodeid);
    }

    @DeleteMapping("/deletewatched/{userid}/{episodeid}")
    public void deleteFromUserWatchedList(@PathVariable Long userid, @PathVariable Long episodeid) throws Exception {
        userService.deleteFromUserWatchedList(userid, episodeid);
    }
}

