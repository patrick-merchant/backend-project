package com.bnta.just_listen_api.repositories;

import com.bnta.just_listen_api.models.Podcast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PodcastRepository extends JpaRepository<Podcast, Long> {

    // DERIVED QUERIES
    List<Podcast> findPodcastByTitleContainingIgnoreCase (String title);
    List<Podcast> findPodcastByDescriptionContainingIgnoreCase (String description);
    List<Podcast> findPodcastByCategoryContainingIgnoreCase (String category);
    List<Podcast> findPodcastByRatingGreaterThan (float rating);
    List<Podcast> findPodcastBySourcesContainingIgnoreCase (String sources);

    // traverses association between Podcast and Episode
    List<Podcast> findByPodcastEpisodesNameContainingIgnoreCase (String infix);

}
