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
        Podcast podcast1 = new Podcast("Off Menu", "N/A", "Ed Gamble and James Acaster interview celebrity guests by discussing their dream menu!",
                "Comedy, Family", (float) 4.9, "Spotify, www.offmenupodcast.co.uk, ApplePodcasts, ACast");
        Podcast podcast2 = new Podcast("No Such Thing As A Fish", "N/A", "The braniacs behind QI present their favourite facts each week.",
                "Comedy, Family, Factual", (float) 4.5, "Spotify, ApplePodcasts");
        Podcast podcast3 = new Podcast("The Diary of a CEO, With Steven Bartlett", "N/A", "This 29 year old dragon invites guests from different backgrounds to discuss what it's like to be an entrepreneur.",
                "Business, Health", (float) 4.9, "Spotify, ApplePodcasts");
        podcastRepository.saveAll(Arrays.asList(podcast1, podcast2, podcast3));

        // add some contributors.
        Contributor contributor1 = new Contributor("James Acaster", "Comedian", true);
        Contributor contributor2 = new Contributor("Ed Gamble", "Comedian", true);
        Contributor contributor3 = new Contributor("Scroobius Pip", "Podcaster", false);
        Contributor contributor4 = new Contributor("Dan Schreiber", "Researcher, Podcaster", true);
        Contributor contributor5 = new Contributor("James Harkin", "Researcher, Podcaster", true);
        Contributor contributor6 = new Contributor("Andrew Hunter Murray", "Researcher, Podcaster", true);
        Contributor contributor7 = new Contributor("Anna Ptaszynski", "Researcher, Podcaster", true);
        Contributor contributor8 = new Contributor("Steven Bartlett", "Entrepreneur", true);
        Contributor contributor9 = new Contributor("Simon Sinek", "Author, Public Speaker", false);
        contributorRepository.saveAll(Arrays.asList(contributor1, contributor2, contributor3, contributor4, contributor5,
                        contributor6, contributor7, contributor8, contributor9));


        // add some episodes.
        Episode p1Episode1 = new Episode("Ep 1: Scroobius Pip","It’s the grand opening of the magical restaurant and the" +
                " first guest through the doors is Mr Podcast himself, Scroobius Pip.", 66, LocalDate.of(2018,12,05),
                podcast1, Arrays.asList(contributor1,contributor2,contributor3));
        Episode p2Episode1 = new Episode("Ep 1: No such thing as a magnetic skate board", "Dan, James, " +
                "Anna and Andy discuss a cupboard full of clown heads, " +
                "the robot that doesn’t jump over the moon and the rock and roll side of pension planning.",54,
                LocalDate.of(2022, 05, 20), podcast2, Arrays.asList(contributor4, contributor5,
                contributor6, contributor7));
        Episode p3Episode1 = new Episode("Ep 1: Simon Sinek"," Simon Sinek is an author and public speaker, " +
                "and one of the most interesting" +
                " thinkers on business in the world today.", 95, LocalDate.of(2022, 05, 23), podcast3,
                 Arrays.asList(contributor8, contributor9));
        episodeRepository.saveAll(Arrays.asList(p1Episode1,p2Episode1,p3Episode1));



    }
}
