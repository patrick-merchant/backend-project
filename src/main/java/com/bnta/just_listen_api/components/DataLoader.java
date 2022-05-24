package com.bnta.just_listen_api.components;

import com.bnta.just_listen_api.models.Contributor;
import com.bnta.just_listen_api.models.Episode;
import com.bnta.just_listen_api.models.Podcast;
import com.bnta.just_listen_api.repositories.ContributorRepository;
import com.bnta.just_listen_api.repositories.EpisodeRepository;
import com.bnta.just_listen_api.repositories.PodcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private PodcastRepository podcastRepository;

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private EpisodeRepository episodeRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        // add some podcasts.
        Podcast offMenu = new Podcast("Off Menu", "N/A", "Ed Gamble and James Acaster interview celebrity guests by discussing their dream menu!",
                "Comedy, Family", (float) 4.9, "Spotify, www.offmenupodcast.co.uk, ApplePodcasts, ACast");
        Podcast noSuchThing = new Podcast("No Such Thing As A Fish", "N/A", "The braniacs behind QI present their favourite facts each week.",
                "Comedy, Family, Factual", (float) 4.5, "Spotify, ApplePodcasts");
        Podcast diaryOfACEO = new Podcast("The Diary of a CEO, With Steven Bartlett", "N/A", "This 29 year old dragon invites guests from different backgrounds to discuss what it's like to be an entrepreneur.",
                "Business, Health", (float) 4.9, "Spotify, ApplePodcasts");
        podcastRepository.saveAll(Arrays.asList(offMenu, noSuchThing, diaryOfACEO));

        // add some contributors.
        Contributor jamesAcaster = new Contributor("James Acaster", "Comedian", true);
        Contributor edGamble = new Contributor("Ed Gamble", "Comedian", true);
        Contributor scroobiusPip = new Contributor("Scroobius Pip", "Podcaster", false);
        Contributor danSchreiber = new Contributor("Dan Schreiber", "Researcher, Podcaster", true);
        Contributor jamesHarkin = new Contributor("James Harkin", "Researcher, Podcaster", true);
        Contributor andrewHunterMurray = new Contributor("Andrew Hunter Murray", "Researcher, Podcaster", true);
        Contributor annaPtaszynski = new Contributor("Anna Ptaszynski", "Researcher, Podcaster", true);
        Contributor stevenBartlett = new Contributor("Steven Bartlett", "Entrepreneur", true);
        Contributor simonSinek = new Contributor("Simon Sinek", "Author, Public Speaker", false);
        contributorRepository.saveAll(Arrays.asList(jamesAcaster, edGamble, scroobiusPip, danSchreiber, jamesHarkin,
                        andrewHunterMurray, annaPtaszynski, stevenBartlett, simonSinek));


        // add some episodes.
        Episode offMenu_Ep1 = new Episode("Ep 1: Scroobius Pip","It’s the grand opening of the magical restaurant and the" +
                " first guest through the doors is Mr Podcast himself, Scroobius Pip.", 66, LocalDate.of(2018,12,05),
                offMenu, Arrays.asList(jamesAcaster,edGamble,scroobiusPip));
        Episode noSuchThing_Ep1 = new Episode("No Such Thing As A Magnetic Skate Board", "Dan, James, " +
                "Anna and Andy discuss a cupboard full of clown heads, " +
                "the robot that doesn’t jump over the moon and the rock and roll side of pension planning.",54,
                LocalDate.of(2022, 05, 20), noSuchThing, Arrays.asList(danSchreiber, jamesHarkin,
                andrewHunterMurray, annaPtaszynski));
        Episode diaryOfACEO_Ep145 = new Episode("E145: Simon Sinek: The Number One Reason Why You're Not Succeeding"," Simon Sinek is an author and public speaker, " +
                "and one of the most interesting" +
                " thinkers on business in the world today.", 95, LocalDate.of(2022, 05, 23), diaryOfACEO,
                 Arrays.asList(stevenBartlett, simonSinek));
        episodeRepository.saveAll(Arrays.asList(offMenu_Ep1,noSuchThing_Ep1,diaryOfACEO_Ep145));



    }
}
