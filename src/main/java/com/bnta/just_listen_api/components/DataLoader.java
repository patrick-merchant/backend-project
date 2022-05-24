package com.bnta.just_listen_api.components;

import com.bnta.just_listen_api.models.Podcast;
import com.bnta.just_listen_api.repositories.ContributorRepository;
import com.bnta.just_listen_api.repositories.EpisodeRepository;
import com.bnta.just_listen_api.repositories.PodcastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ContributorRepository contributorRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private PodcastRepository podcastRepository;

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

        // add some episodes.

    }
}
