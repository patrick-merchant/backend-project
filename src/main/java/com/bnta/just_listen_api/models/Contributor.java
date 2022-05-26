package com.bnta.just_listen_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contributors")
public class Contributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String profession;

    @ManyToMany(mappedBy = "contributors")
    @JsonIgnoreProperties({"contributors", "podcast"}) // second ignored property makes data readable.
    private List<Episode> episodesFeaturing;

    @Column
    private boolean isPresenter;


    // DEFAULT CONSTRUCTORS
    public Contributor() {
    }


    // CONSTRUCTOR
    public Contributor(String name, String profession, boolean isPresenter) {
        this.name = name;
        this.profession = profession;
        this.isPresenter = isPresenter;
        this.episodesFeaturing = new ArrayList<Episode>();
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<Episode> getEpisodesFeaturing() {
        return episodesFeaturing;
    }

    public void setEpisodesFeaturing(List<Episode> episodesFeaturing) {
        this.episodesFeaturing = episodesFeaturing;
    }

    public boolean isPresenter() {
        return isPresenter;
    }

    public void setPresenter(boolean presenter) {
        isPresenter = presenter;
    }


    @Override
    public String toString() {
        return "Contributor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", episodesFeaturing=" + episodesFeaturing +
                ", isPresenter=" + isPresenter +
                '}';
    }
}
