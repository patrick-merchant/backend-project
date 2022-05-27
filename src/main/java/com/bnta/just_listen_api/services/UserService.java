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
    private EpisodeService episodeService;

    public UserService(UserRepository userRepository, PodcastService podcastService, EpisodeService episodeService) {
        this.userRepository = userRepository;
        this.podcastService = podcastService;
        this.episodeService = episodeService;
    }

    // Check if a user has a recommendation
    // Gives the user a maximum of 3 recommendations
    // Check if the recommendation is already in the list
    public void giveUserAPodcastRec(Long id) throws Exception {
        List<Long> watchedIDs = userRepository.getUsersWatchedPodcasts(id);
        List<Long> existingRecsIDs = userRepository.getUsersRecs(id);
        List<Podcast> allPodcasts = podcastService.findAll();
        Long randomId = new Random().nextLong(allPodcasts.size() + 1);

        if (!userRepository.findById(id).isEmpty()) {
            if (watchedIDs.size() != allPodcasts.size()) {
                if (existingRecsIDs.size() < 3) {
                    while (existingRecsIDs.contains(randomId) || watchedIDs.contains(randomId) || randomId == 0) {
                        randomId = new Random().nextLong(allPodcasts.size() + 1);
                    }
                    userRepository.addRec(id, randomId);
                } else {
                    throw new Exception("Sorry you can only have 3 recommendations at a time." +
                            "Please delete one and then try again");
                }
            } else {
                throw new Exception("Sorry we don't currently have any recommendations for you");
            }
        } else {
            throw new Exception("User with id " + id + " not found");
        }
    }


    public void giveUser3Recs(Long id) throws Exception {
        List<Long> watchedIDs = userRepository.getUsersWatchedPodcasts(id);
        List<Podcast> allPodcasts = podcastService.findAll();
        int count = 0;

        if (watchedIDs.size() == allPodcasts.size() - 2) {
            count = 1;
        } else if (watchedIDs.size() == allPodcasts.size() - 1) {
            count = 2;
        } else if (watchedIDs.size() == allPodcasts.size()) {
            throw new Exception("Sorry we don't currently have any recommendations for you");
        }
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

        while (existingRecsIDs.contains(podcastid)) {
            if (existingRecsIDs.contains(podcastid)) {
                deleteUsersRec(userid, podcastid);
                giveUserAPodcastRec(userid);
                break;
            }
        }
    }


    public void addWatchedEpisodeToUserWatchedList(Long userid, Long episodeid) throws Exception {
        List<Long> watchedIDs = userRepository.getUsersWatchedEpisodes(episodeid);
        if (!userRepository.findById(userid).isEmpty()) {
            if (!episodeService.findById(episodeid).isEmpty()) {
                if (!watchedIDs.contains(episodeid)) {
                    userRepository.addEpToUsersWatchedList(userid, episodeid);
                } else {
                    throw new Exception("The episode has already been marked as watched");
                }
            } else {
                throw new Exception("episode with id " + episodeid + " doesn't exist");
            }
        } else {
            throw new Exception("user with id " + userid + " doesn't exist");
        }
    }


    public void deleteFromUserWatchedList(Long userid, Long episodeid) throws Exception {
        List<Long> watchedIDs = userRepository.getUsersWatchedEpisodes(episodeid);
        if (!userRepository.findById(userid).isEmpty()) {
            if (!episodeService.findById(episodeid).isEmpty()) {
                if (watchedIDs.contains(episodeid)) {
                    userRepository.deleteFromUserWatchedList(userid, episodeid);
                } else {
                    throw new Exception("Error: the episode with id " + episodeid + " hasn't been marked as watched by the user with id " + userid);
                }
            } else {
                throw new Exception("episode with id " + episodeid + " doesn't exist");
            }
        } else {
            throw new Exception("user with id " + userid + " doesn't exist");
        }
    }
}
