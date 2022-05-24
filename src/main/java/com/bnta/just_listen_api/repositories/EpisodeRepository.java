package com.bnta.just_listen_api.repositories;

import com.bnta.just_listen_api.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {

    // DERIVED QUERIES
    List<Episode> findEpisodeByNameContainingIgnoreCase (String name);
    List<Episode> findEpisodeByDescriptionContainingIgnoreCase (String description);
   // List<Episode> findEpisodeByMostRecentlyPostedDesc (LocalDate datePosted);
    List<Episode> findEpisodeByDurationLessThan (int duration);

}
