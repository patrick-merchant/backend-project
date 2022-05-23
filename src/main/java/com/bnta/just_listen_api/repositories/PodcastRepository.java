package com.bnta.just_listen_api.repositories;

import com.bnta.just_listen_api.models.Podcast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PodcastRepository extends JpaRepository<Podcast, Long> {
}
