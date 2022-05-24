package com.bnta.just_listen_api;

import com.bnta.just_listen_api.models.Episode;
import com.bnta.just_listen_api.repositories.EpisodeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class JustListenApiApplicationTests {

	@Autowired
	EpisodeRepository episodeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindEpisodeByNameContainingEp1 () {
		List<Episode> found = episodeRepository.findEpisodeByNameContainingIgnoreCase("ep 1");
		assertThat(found.size()).isEqualTo(3);
	}

	@Test
	public void canFindEpisodeByNameContainingSimon () {
		List<Episode> found = episodeRepository.findEpisodeByNameContainingIgnoreCase("simon");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canFindEpisodeByNameContaining1 () {
		List<Episode> found = episodeRepository.findEpisodeByNameContainingIgnoreCase("1");
		assertThat(found.size()).isEqualTo(3);
	}

	@Test
	public void canFindEpisodeByDescriptionContainingInteresting () {
		List<Episode> found = episodeRepository.findEpisodeByDescriptionContainingIgnoreCase("INTERESTING");
		assertThat(found.size()).isEqualTo(1);
	}

	@Test
	public void canFindByEpisodeDurationLessThan() {
		List<Episode> found = episodeRepository.findEpisodeByDurationLessThan(60);
		assertThat(found.size()).isEqualTo(1);
	}

}
