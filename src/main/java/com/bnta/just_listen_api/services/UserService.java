package com.bnta.just_listen_api.services;

import com.bnta.just_listen_api.models.Podcast;
import com.bnta.just_listen_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

    private UserRepository userRepository;
    private PodcastService podcastService;

    public UserService(UserRepository userRepository, PodcastService podcastService) {
        this.userRepository = userRepository;
        this.podcastService = podcastService;
    }


    public void giveUserAPodcastRec(Long id) throws Exception {
        List<Long> watchedIDs = userRepository.getUsersWatched(id);
        List<Long> existingRecsIDs = userRepository.getUsersRecs(id);
        List<Podcast> allPodcasts = podcastService.findAll();
        Long randomId = new Random().nextLong(allPodcasts.size() + 1);
        if (!userRepository.findById(id).isEmpty()) {
            if (existingRecsIDs.size() < 3) {
                while (existingRecsIDs.contains(randomId) || watchedIDs.contains(randomId) || randomId == 0) {
                    randomId = new Random().nextLong(allPodcasts.size() + 1);
                }
                userRepository.addRec(id, randomId);

            } else {
                throw new Exception("Sorry you can only have 3 recommendations at a time. Please delete one and then try again");
            }
        } else {
            throw new Exception("User with id " + id + " not found");
        }
    }

    public void giveUser3Recs(Long id) throws Exception {
        int count = 0;
        while (count < 3) {
            count++;
            giveUserAPodcastRec(id);
        }
    }

    public void deleteUsersRec(Long userid, Long podcastid) {
        userRepository.deleteRec(userid, podcastid);

    }

    public void replacePodcastRec(Long userid, Long podcastid) throws Exception {
        List<Long> existingRecsIDs = userRepository.getUsersRecs(userid);
        int count = 0;
        while (existingRecsIDs.contains(podcastid)) {
            if (existingRecsIDs.contains(podcastid)) {
                deleteUsersRec(userid, podcastid);
                giveUserAPodcastRec(userid);
                break;
            }
        }

    }

}
