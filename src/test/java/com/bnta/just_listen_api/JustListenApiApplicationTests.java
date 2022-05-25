package com.bnta.just_listen_api;

import com.bnta.just_listen_api.models.Contributor;
import com.bnta.just_listen_api.models.Episode;
import com.bnta.just_listen_api.models.Podcast;
import com.bnta.just_listen_api.repositories.ContributorRepository;
import com.bnta.just_listen_api.repositories.EpisodeRepository;
import com.bnta.just_listen_api.repositories.PodcastRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class JustListenApiApplicationTests {

	@Autowired
	private EpisodeRepository episodeRepository;

	@Autowired
	private PodcastRepository podcastRepository;

	@Autowired
	private ContributorRepository contributorRepository;

	@Test
	void contextLoads() {
	}

	//------------------------------ Episode Query Tests -------------------------------\\

	@Test
	public void canFindEpisodeByNameContainingEp1 () {
		List<Episode> found = episodeRepository.findEpisodeByNameContainingIgnoreCase("ep 1");
		assertThat(found.size()).isEqualTo(2);
	}

	@Test
	public void canFindEpisodeByNameContainingSimon () {
		List<Episode> found = episodeRepository.findEpisodeByNameContainingIgnoreCase("simon");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canFindEpisodeByNameContaining1 () {
		List<Episode> found = episodeRepository.findEpisodeByNameContainingIgnoreCase("1");
		assertThat(found.size()).isEqualTo(9);
	}

	@Test
	public void canFindEpisodeByDescriptionContainingInteresting () {
		List<Episode> found = episodeRepository.findEpisodeByDescriptionContainingIgnoreCase("INTERESTING");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canFindByEpisodeDurationLessThan60 () {
		List<Episode> found = episodeRepository.findEpisodeByDurationLessThan(60);
		assertThat(found.size()).isEqualTo(3);
	}

	@Test
	public void canFindEpisodeByContributorsNameContainingIgnoreCase() {
		List<Episode> found = episodeRepository.findEpisodeByContributorsNameContainingIgnoreCase("James Acaster");
		assertThat(found.size()).isEqualTo(6);
	}


	//------------------------------ Podcast Query Tests -------------------------------\\

	@Test
	public void canFindPodcastByTitleContainingCEO () {
		List<Podcast> found = podcastRepository.findPodcastByTitleContainingIgnoreCase("ceo");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canFindPodcastByDescriptionContainingGuests () {
		List<Podcast> found = podcastRepository.findPodcastByDescriptionContainingIgnoreCase("GUESTS");
		assertThat(found.size()).isEqualTo(2);
	}

	@Test
	public void canFindPodcastByCategoryContainingComedy() {
		List<Podcast> found = podcastRepository.findPodcastByCategoryContainingIgnoreCase("coMedy");
		assertThat(found.size()).isEqualTo(4);
	}

	@Test
	public void canFindPodcastByRatingGreaterThan3() {
		List<Podcast> found = podcastRepository.findPodcastByRatingGreaterThan(3);
		assertThat(found.size()).isEqualTo(6);
	}

	@Test
	public void canFindPodcastBySourceContainingSpotify() {
		List<Podcast> found = podcastRepository.findPodcastBySourcesContainingIgnoreCase("SpoTify");
		assertThat(found.size()).isEqualTo(6);
	}

	@Test
	public void canFindEpisodesByNameContainingEp1ScroobiusPip() {
		assertThat(podcastRepository.findByPodcastEpisodesNameContainingIgnoreCase("Ep 1: Scroobius Pip").size()).isEqualTo(1);
	}


	//------------------------------ Contributor Query Tests -------------------------------\\

	@Test
	public void canFindContributorByNameJames () {
		List<Contributor> found = contributorRepository.findContributorByNameContainingIgnoreCase("JaMes");
		assertThat(found.size()).isEqualTo(3);
	}

	@Test
	public void canFindContributorByProfessionResearcher () {
		List<Contributor> found = contributorRepository.findContributorByProfessionContainingIgnoreCase("RESEARCHER");
		assertThat(found.size()).isEqualTo(4);
	}

	@Test
	public void canFindContributorByIsPresenterTrue () {
		List<Contributor> found = contributorRepository.findContributorByIsPresenter(true);
		assertThat(found.size()).isEqualTo(11);
	}


}
