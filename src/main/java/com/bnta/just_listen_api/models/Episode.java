package com.bnta.just_listen_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int duration;

    @Column
    private LocalDate datePosted;

    @ManyToMany
    @JsonIgnoreProperties({"episodes", "episodesFeaturing"}) // second ignored property makes data readable.
    @JoinTable(
            name = "episodes_contributors",
            joinColumns = {@JoinColumn(name = "episode_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "contributor_id", nullable = false)})
    private List<Contributor> contributors;

    @ManyToOne
    @JsonIgnoreProperties({"podcastEpisodes"}) // singular or plural?
    @JoinColumn(name = "podcast_id") // nullable?
    private Podcast podcast;

    // DEFAULT CONSTRUCTOR
    public Episode() {
    }

    // CONSTRUCTOR
    public Episode(String name, String description, int duration, LocalDate datePosted, Podcast podcast, List<Contributor> contributors) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.datePosted = datePosted;
        this.podcast = podcast;
        this.contributors = contributors;
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
