package com.bnta.just_listen_api.models;

import java.util.ArrayList;
import java.util.List;

public class Podcast {
    private Long id;

    private String title;
    private String triggerWarning;
    private String description;
    private String category;
    private float rating;

    private String sources;

    private List<Episode> podcastEpisodes;


    // DEFAULT CONSTRUCTOR
    public Podcast() {
    }

    public Podcast(String title, String triggerWarning, String description, String category,
                   float rating, String sources) {
        this.title = title;
        this.triggerWarning = triggerWarning;
        this.description = description;
        this.category = category;
        this.rating = rating;
        this.sources = sources;
        this.podcastEpisodes = new ArrayList<>();
    }


    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTriggerWarning() {
        return triggerWarning;
    }

    public void setTriggerWarning(String triggerWarning) {
        this.triggerWarning = triggerWarning;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public List<Episode> getPodcastEpisodes() {
        return podcastEpisodes;
    }

    public void setPodcastEpisodes(List<Episode> podcastEpisodes) {
        this.podcastEpisodes = podcastEpisodes;
    }


    @Override
    public String toString() {
        return "Podcast{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", triggerWarning='" + triggerWarning + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", sources='" + sources + '\'' +
                ", podcastEpisodes=" + podcastEpisodes +
                '}';
    }
}
