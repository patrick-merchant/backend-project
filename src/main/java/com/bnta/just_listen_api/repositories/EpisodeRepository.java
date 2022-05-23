package com.bnta.just_listen_api.repositories;

import com.bnta.just_listen_api.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
