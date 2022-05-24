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
        Podcast distractionPieces = new Podcast("Distraction Pieces", "N/A", "Distraction Pieces, with Scroobius Pip, is one the UK's biggest and longest running independent podcasts.",
                "Comedy", (float) 4.7, "Acast, Spotify, ApplePodcasts");
        Podcast filmsToBeBuriedWith = new Podcast("Films To Be Buried With", "Death" "We are born. We die. In between we watch a lot of films. And some of these films shape the people we are. " +
                "This is a podcast about those films. (And a bit about death.)", "Comedy", (float) 4.8, "Spotify, ApplePodcasts, Acast");
        podcastRepository.saveAll(Arrays.asList(offMenu, noSuchThing, diaryOfACEO, distractionPieces, filmsToBeBuriedWith));

        // add some contributors.
        Contributor jamesAcasterPresenter = new Contributor("James Acaster", "Comedian", true);
        Contributor jamesAcasterGuest = new Contributor("James Acaster", "Comedian", false);
        Contributor edGamblePresenter = new Contributor("Ed Gamble", "Comedian", true);
        Contributor edGambleGuest = new Contributor("Ed Gamble", "Comedian", false);
        Contributor brettGoldsteinPresenter = new Contributor("Brett Goldstein", "Comedian, Actor", true);
        Contributor brettGoldsteinGuest = new Contributor("Brett Goldstein", "Comedian, Actor", false);
        Contributor scroobiusPipGuest = new Contributor("Scroobius Pip", "Rapper, Podcaster, Actor, Record Label Owner", false);
        Contributor scroobiusPipPresenter = new Contributor("Scroobius Pip", "Rapper, Podcaster, Actor, Record Label Owner", true);
        Contributor danSchreiber = new Contributor("Dan Schreiber", "Researcher, Podcaster", true);
        Contributor jamesHarkin = new Contributor("James Harkin", "Researcher, Podcaster", true);
        Contributor andrewHunterMurray = new Contributor("Andrew Hunter Murray", "Researcher, Podcaster", true);
        Contributor annaPtaszynski = new Contributor("Anna Ptaszynski", "Researcher, Podcaster", true);
        Contributor stevenBartlett = new Contributor("Steven Bartlett", "Entrepreneur", true);
        Contributor simonSinek = new Contributor("Simon Sinek", "Author, Public Speaker", false);
        contributorRepository.saveAll(Arrays.asList(jamesAcasterPresenter, jamesAcasterGuest, edGamblePresenter, edGambleGuest,
                brettGoldsteinPresenter, brettGoldsteinGuest, scroobiusPipGuest, scroobiusPipPresenter, danSchreiber, jamesHarkin,
                        andrewHunterMurray, annaPtaszynski, stevenBartlett, simonSinek));


        // add some episodes.
        Episode offMenu_Ep1 = new Episode("Ep 1: Scroobius Pip","It’s the grand opening of the magical restaurant and the" +
                " first guest through the doors is Mr Podcast himself, Scroobius Pip.", 66, LocalDate.of(2018,12,05),
                offMenu, Arrays.asList(jamesAcasterPresenter,edGamblePresenter,scroobiusPipGuest));
        Episode offMenu_EpGoldstein1 = new Episode("Menus To Be Buried With", "Look out, it's only a crossover episode! Peddy Bambles " +
                "and The Genie team up with Bradley Goldstein for this Acast Red Nose Day Mashup podcast, all in aid of Comic Relief.",
                65, LocalDate.of(2021, 03, 14), offMenu, Arrays.asList(jamesAcasterPresenter, edGamblePresenter, brettGoldsteinGuest));
        Episode noSuchThing_Ep1 = new Episode("No Such Thing As A Magnetic Skate Board", "Dan, James, " +
                "Anna and Andy discuss a cupboard full of clown heads, " +
                "the robot that doesn’t jump over the moon and the rock and roll side of pension planning.",54,
                LocalDate.of(2022, 05, 20), noSuchThing, Arrays.asList(danSchreiber, jamesHarkin,
                andrewHunterMurray, annaPtaszynski));
        Episode diaryOfACEO_Ep145 = new Episode("E145: Simon Sinek: The Number One Reason Why You're Not Succeeding"," Simon Sinek is an author and public speaker, " +
                "and one of the most interesting" +
                " thinkers on business in the world today.", 95, LocalDate.of(2022, 05, 23), diaryOfACEO,
                 Arrays.asList(stevenBartlett, simonSinek));
        Episode distractionPieces_Ep265 = new Episode("#265: Ed Gamble", "Welcome, welcome, welcome to episode 265 of the Distraction Pieces Podcast with Scroobius Pip! A great one here " +
                "with comedian, podcaster and metaler ED GAMBLE!", 76, LocalDate.of(2019, 05, 01), distractionPieces,
                Arrays.asList(scroobiusPipPresenter, edGambleGuest));
        Episode distractionPieces_Ep104 = new Episode("#104: James Acaster", "Prepare yourselves for another heavy hitting good'un as Pip is joined by " +
                "none other than UK comedy titan and overlord James Acaster!", 103, LocalDate.of(2016, 06, 05), distractionPieces,
                Arrays.asList(scroobiusPipPresenter, jamesAcasterGuest));
        Episode distractionPieces_Ep325 = new Episode("#325: Isolation DrunkCast v.2 (pt. 1 of 3)", "We are still in lockdown (lockdown has been lifted), " +
                "and while we’re all going in to work (no going into work) and staying alert (SO much more alert than usual), Pip decided to round up a willing crew for " +
                "some further drunk antics by way of the second ISOLATION DRUNKCAST!", 96, LocalDate.of(2020, 05, 13), distractionPieces,
                Arrays.asList(scroobiusPipPresenter, jamesAcasterGuest, edGambleGuest));
        episodeRepository.saveAll(Arrays.asList(offMenu_Ep1, offMenu_EpGoldstein1, noSuchThing_Ep1, diaryOfACEO_Ep145,
                distractionPieces_Ep265, distractionPieces_Ep104, distractionPieces_Ep325));



    }
}
