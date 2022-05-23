package com.bnta.just_listen_api.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Episode {

    private Long id;
    private String name;
    private String description;
    private int duration;
    private LocalDate datePosted;
    private List<Contributor> contributors;
    private Podcast podcast;

    // DEFAULT CONSTRUCTOR
    public Episode(){

    }

    // CONSTRUCTOR
    public Episode(String name, String description, int duration, LocalDate datePosted, Podcast podcast){
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.datePosted = datePosted;
        this.contributors = new ArrayList<>();
        this.podcast = podcast;
    }

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public Podcast getPodcast() {
        return podcast;
    }

    public void setPodcast(Podcast podcast) {
        this.podcast = podcast;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", datePosted=" + datePosted +
                ", contributors=" + contributors +
                ", podcast=" + podcast +
                '}';
    }
}
