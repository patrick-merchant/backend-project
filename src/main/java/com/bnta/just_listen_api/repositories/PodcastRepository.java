package com.bnta.just_listen_api.repositories;

import com.bnta.just_listen_api.models.Podcast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PodcastRepository extends JpaRepository<Podcast, Long> {

    // DERIVED QUERIES
    List<Podcast> findPodcastByTitleContainingIgnoreCase (String title);
    List<Podcast> findPodcastByDescriptionContainingIgnoreCase (String description);
    List<Podcast> findPodcastByCategoryIgnoreCase (String category);
    List<Podcast> findPodcastByRatingGreaterThan (float rating);
    List<Podcast> findPodcastBySource (String source);

}
