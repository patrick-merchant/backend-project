package com.bnta.just_listen_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "podcasts")
public class Podcast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String contentNote;

    @Column
    private String description;

    @Column
    private String category;

    @Column
    private float rating;

    @Column
    private String sources;

    @OneToMany(mappedBy = "podcast", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"podcast", "contributors"})  // second ignored property makes data readable.
    private List<Episode> podcastEpisodes;


    // DEFAULT CONSTRUCTOR
    public Podcast() {
    }

    // CONSTRUCTOR
    public Podcast(String title, String contentNote, String description, String category,
                   float rating, String sources) {
        this.title = title;
        this.contentNote = contentNote;
        this.description = description;
        this.category = category;
        this.rating = rating;
        this.sources = sources;
        this.podcastEpisodes = new ArrayList<>();
    }


    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentNote() {
        return contentNote;
    }

    public void setContentNote(String contentNote) {
        this.contentNote = contentNote;
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
                ", contentNote='" + contentNote + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", sources='" + sources + '\'' +
                ", podcastEpisodes=" + podcastEpisodes +
                '}';
    }
}
