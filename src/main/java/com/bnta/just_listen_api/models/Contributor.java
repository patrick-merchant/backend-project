package com.bnta.just_listen_api.models;

import java.util.ArrayList;
import java.util.List;

public class Contributor {

    private Long id;
    private String name;
    private String profession;
    private List<Episode> episodesFeaturing;
    private boolean isPresenter;

    //constructors(2)

    //(1) no args constructor
    public Contributor() {
    }

    //(2) args constructor


    public Contributor(String name, String profession, boolean isPresenter) {
        this.name = name;
        this.profession = profession;
        this.isPresenter = isPresenter;
        this.episodesFeaturing = new ArrayList<Episode>();
    }

    //Getters + Setters


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
