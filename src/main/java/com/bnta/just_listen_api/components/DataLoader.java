package com.bnta.just_listen_api.components;

import com.bnta.just_listen_api.models.Contributor;
import com.bnta.just_listen_api.models.Episode;
import com.bnta.just_listen_api.models.Podcast;
import com.bnta.just_listen_api.models.User;
import com.bnta.just_listen_api.repositories.ContributorRepository;
import com.bnta.just_listen_api.repositories.EpisodeRepository;
import com.bnta.just_listen_api.repositories.PodcastRepository;
import com.bnta.just_listen_api.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        // ADD PODCASTS
        Podcast offMenu = new Podcast("Off Menu", "N/A", "Ed Gamble and James Acaster interview celebrity guests by discussing their dream menu!",
                "Comedy, Family", (float) 4.9, "Spotify, www.offmenupodcast.co.uk, ApplePodcasts, ACast");
        Podcast noSuchThing = new Podcast("No Such Thing As A Fish", "N/A", "The braniacs behind QI present their favourite facts each week.",
                "Comedy, Family, Factual", (float) 4.5, "Spotify, ApplePodcasts");
        Podcast diaryOfACEO = new Podcast("The Diary of a CEO, With Steven Bartlett", "N/A", "This 29 year old dragon invites guests from different backgrounds to discuss what it's like to be an entrepreneur.",
                "Business, Health", (float) 4.9, "Spotify, ApplePodcasts");
        Podcast distractionPieces = new Podcast("Distraction Pieces", "N/A", "Distraction Pieces, with Scroobius Pip, is one the UK's biggest and longest running independent podcasts.",
                "Comedy", (float) 4.7, "Acast, Spotify, ApplePodcasts");
        Podcast filmsToBeBuriedWith = new Podcast("Films To Be Buried With", "Death", "We are born. We die. In between we watch a lot of films. And some of these films shape the people we are. " +
                "This is a podcast about those films. (And a bit about death.)", "Comedy", (float) 4.8, "Spotify, ApplePodcasts, Acast");
        Podcast badTrueCrimePodcast = new Podcast("A Bad True Crime Podcast", "Death, Violence", "Someone has been accused of murder. Did they do it?",
                "True Crime", (float) 2.3, "Acast");
        Podcast averageSportsPodcast = new Podcast("An Average Sports Podcast", "Gambling", "Footballer Peter Crouch has made another podcast - it's alright.",
                "Sport", (float) 3.7, "Spotify");

        podcastRepository.saveAll(Arrays.asList(offMenu, noSuchThing, diaryOfACEO, distractionPieces, filmsToBeBuriedWith, badTrueCrimePodcast, averageSportsPodcast));


        // ADD CONTRIBUTORS
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
        Contributor sherlockHolmes = new Contributor("Sherlock Holmes", "Private Detective", false);
        Contributor drWatson = new Contributor("Dr John Watson", "Blogger, Podcaster", true);
        Contributor peterCrouch = new Contributor("Peter Crouch", "Footballer, Podcaster", true);
        Contributor garyLineker = new Contributor("Gary Lineker", "Footballer, Pundit", false);
        contributorRepository.saveAll(Arrays.asList(jamesAcasterPresenter, jamesAcasterGuest, edGamblePresenter, edGambleGuest,
                brettGoldsteinPresenter, brettGoldsteinGuest, scroobiusPipGuest, scroobiusPipPresenter, danSchreiber, jamesHarkin,
                andrewHunterMurray, annaPtaszynski, stevenBartlett, simonSinek, sherlockHolmes, drWatson, peterCrouch, garyLineker));


        // ADD EPISODES
        Episode offMenu_Ep1 = new Episode("Ep 1: Scroobius Pip", "It’s the grand opening of the magical restaurant and the" +
                " first guest through the doors is Mr Podcast himself, Scroobius Pip.", 66, LocalDate.of(2018, 12, 5),
                offMenu, Arrays.asList(jamesAcasterPresenter, edGamblePresenter, scroobiusPipGuest));
        Episode offMenu_EpGoldstein1 = new Episode("Menus To Be Buried With", "Look out, it's only a crossover episode! Peddy Bambles " +
                "and The Genie team up with Bradley Goldstein for this Acast Red Nose Day Mashup podcast, all in aid of Comic Relief.",
                65, LocalDate.of(2021, 3, 14), offMenu, Arrays.asList(jamesAcasterPresenter, edGamblePresenter, brettGoldsteinGuest));
        Episode noSuchThing_Ep1 = new Episode("No Such Thing As A Magnetic Skate Board", "Dan, James, " +
                "Anna and Andy discuss a cupboard full of clown heads, " +
                "the robot that doesn’t jump over the moon and the rock and roll side of pension planning.", 54,
                LocalDate.of(2022, 5, 20), noSuchThing, Arrays.asList(danSchreiber, jamesHarkin,
                andrewHunterMurray, annaPtaszynski));
        Episode diaryOfACEO_Ep145 = new Episode("E145: Simon Sinek: The Number One Reason Why You're Not Succeeding", " Simon Sinek is an author and public speaker, " +
                "and one of the most interesting" +
                " thinkers on business in the world today.", 95, LocalDate.of(2022, 5, 23), diaryOfACEO,
                Arrays.asList(stevenBartlett, simonSinek));
        Episode distractionPieces_Ep265 = new Episode("#265: Ed Gamble", "Welcome, welcome, welcome to episode 265 of the Distraction Pieces Podcast with Scroobius Pip! A great one here " +
                "with comedian, podcaster and metaler ED GAMBLE!", 76, LocalDate.of(2019, 5, 1), distractionPieces,
                Arrays.asList(scroobiusPipPresenter, edGambleGuest));
        Episode distractionPieces_Ep104 = new Episode("#104: James Acaster", "Prepare yourselves for another heavy hitting good'un as Pip is joined by " +
                "none other than UK comedy titan and overlord James Acaster!", 103, LocalDate.of(2016, 6, 5), distractionPieces,
                Arrays.asList(scroobiusPipPresenter, jamesAcasterGuest));
        Episode distractionPieces_Ep325 = new Episode("#325: Isolation DrunkCast v.2 (pt. 1 of 3)", "Pip decided to round up a willing crew for " +
                "some further drunk antics by way of the second ISOLATION DRUNKCAST!", 96, LocalDate.of(2020, 5, 13), distractionPieces,
                Arrays.asList(scroobiusPipPresenter, jamesAcasterGuest, edGambleGuest));
        Episode filmsToBeBuriedWith_Ep4 = new Episode("#4: Scroobius Pip", "What a perfect treat of a guest this week - yes indeed, it is the Distraction Pieces Network head " +
                "honcho and label boss Mr Scroobius Pip!", 76, LocalDate.of(2018, 8, 2), filmsToBeBuriedWith,
                Arrays.asList(brettGoldsteinPresenter, scroobiusPipGuest));
        Episode filmsToBeBuriedWith_Ep150 = new Episode("#150: Scroobius Pip - The Resurrection", "Join your host Brett Goldstein as he talks life, death, love and the universe " +
                "for the second time in a RESURRECTION EDITION of the podcast - this time it’s Distraction Pieces own SCROOBIUS PIP!", 62, LocalDate.of(2021, 6, 10),
                filmsToBeBuriedWith, Arrays.asList(brettGoldsteinPresenter, scroobiusPipGuest));
        Episode filmsToBeBuriedWith_Ep1 = new Episode("#1: James Acaster", "Ladies and gentlemen, welcome to 'Films To Be Buried With' with Brett Goldstein! " +
                "What makes this situation extra special is that you are on board from the ground floor - this is the VERY FIRST episode!", 75, LocalDate.of(2018, 7, 12),
                filmsToBeBuriedWith, Arrays.asList(brettGoldsteinPresenter, jamesAcasterGuest));
        Episode filmsToBeBuriedWith_Ep100 = new Episode("#100: James Acaster - The Resurrection", "Join your host Brett Goldstein as he talks life, death, love and the universe with " +
                "JAMES ACASTER - but wait… Didn’t he die in episode 1, all those years ago…??? Huh…", 107, LocalDate.of(2020, 6, 18),
                filmsToBeBuriedWith, Arrays.asList(brettGoldsteinPresenter, jamesAcasterGuest));
        Episode filmsToBeBuriedWith_Ep9 = new Episode("#9: Ed Gamble", "LOOK OUT! It’s only Films To Be Buried With! Join your host Brett Goldstein as he catches up with pal ED GAMBLE, " +
                "fellow Edinburgh Fringe resident and UK comic and television champion!", 80, LocalDate.of(2018, 9, 6),
                filmsToBeBuriedWith, Arrays.asList(brettGoldsteinPresenter, edGambleGuest));
        Episode filmsToBeBuriedWith_Ep104 = new Episode("#104: Ed Gamble - The Resurrection", "Now I know what you’re all thinking, didn’t Ed die in an earlier episode " +
                "yadda yadda yadda but HOLD ON… Explanations are needed.", 63, LocalDate.of(2020, 7, 16),
                filmsToBeBuriedWith, Arrays.asList(brettGoldsteinPresenter, edGambleGuest));
        Episode badTrueCrimePodcast_Ep1 = new Episode("Ep 1: The Crime", "There was a crime. It was bad.", 45, LocalDate.of(2020, 4, 13),
                badTrueCrimePodcast, Arrays.asList(drWatson, sherlockHolmes));
        Episode averageSportsPodcast_Ep1 = new Episode("The Football This Week", "There were football matches this week. They were good.", 30, LocalDate.of(2021, 9, 19),
                averageSportsPodcast, Arrays.asList(peterCrouch, garyLineker));
        episodeRepository.saveAll(Arrays.asList(offMenu_Ep1, offMenu_EpGoldstein1, noSuchThing_Ep1, diaryOfACEO_Ep145,
                distractionPieces_Ep265, distractionPieces_Ep104, distractionPieces_Ep325, filmsToBeBuriedWith_Ep4, filmsToBeBuriedWith_Ep150, filmsToBeBuriedWith_Ep1, filmsToBeBuriedWith_Ep100,
                filmsToBeBuriedWith_Ep9, filmsToBeBuriedWith_Ep104, badTrueCrimePodcast_Ep1, averageSportsPodcast_Ep1));

        // ADD USERS
        User SarahJane = new User("Sarah123", "Cakebakefake!340", "SarahJane123@gmail.com", false);
        User Bailey = new User("Bailey_B", "ajdogenwof.34/", "Bailey.Buntin@gmail.com", false);
        User Craig = new User("CAllen2", "hghghghj786@@0", "Craig_Allen@yahoo.com", false);
        User Mark = new User("Mark_Dupree", "MD@66.54321", "Mark_Dupree@icloud.com", false);
        User Ashley = new User("Ashley_A", "Admin_123_jv", "Ashley_A@hotmail.co.uk", true);
        userRepository.saveAll(Arrays.asList(SarahJane, Bailey, Craig, Mark, Ashley));
    }
}
