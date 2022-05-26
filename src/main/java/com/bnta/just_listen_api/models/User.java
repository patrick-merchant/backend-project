package com.bnta.just_listen_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private Boolean isAdmin;

    @ManyToMany
    @JsonIgnoreProperties({"users", "contributors"})
    @JoinTable(
            name = "users_watched_episodes",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "episode_id", nullable = false)})
    private List<Episode> watchedEpisodes;


    @ManyToMany
    @JsonIgnoreProperties({"users", "podcastEpisodes"})
    @JoinTable(
            name = "users_recommended_podcasts",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "podcast_id", nullable = false)})
    private List<Podcast> recommendedPodcasts;


    // DEFAULT CONSTRUCTOR
    public User() {
    }

    // CONSTRUCTOR

    public User(String username, String password, String email, Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.isAdmin = isAdmin;
        this.watchedEpisodes = new ArrayList<>();
        this.recommendedPodcasts = new ArrayList<>();
    }


    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public List<Episode> getWatchedEpisodes() {
        return watchedEpisodes;
    }

    public void setWatchedEpisodes(List<Episode> watchedEpisodes) {
        this.watchedEpisodes = watchedEpisodes;
    }

    public List<Podcast> getRecommendedPodcasts() {
        return recommendedPodcasts;
    }

    public void setRecommendedPodcasts(List<Podcast> recommendedPodcasts) {
        this.recommendedPodcasts = recommendedPodcasts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", watchedEpisodes=" + watchedEpisodes +
                ", recommendedPodcasts=" + recommendedPodcasts +
                '}';
    }
}