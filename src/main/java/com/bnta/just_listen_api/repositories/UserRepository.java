package com.bnta.just_listen_api.repositories;

import com.bnta.just_listen_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT podcasts.id FROM podcasts INNER JOIN episodes ON episodes.podcast_id = podcasts.id INNER JOIN users_watched_episodes ON users_watched_episodes.episode_id = episodes.id WHERE users_watched_episodes.user_id = ?1", nativeQuery = true)
    List<Long> getUsersWatchedPodcasts(Long id);

    @Query(value = "SELECT episode_id FROM users_watched_episodes WHERE user_id=?1", nativeQuery = true)
    List<Long> getUsersWatchedEpisodes(Long id);

    @Query(value = "SELECT PODCAST_ID FROM USERS_RECOMMENDED_PODCASTS WHERE USER_ID = ?1", nativeQuery = true)
    List<Long> getUsersRecs(Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USERS_RECOMMENDED_PODCASTS(USER_ID, PODCAST_ID) VALUES(?1, ?2)", nativeQuery = true)
    void addRec(Long userId, Long podcastId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users_recommended_podcasts WHERE user_id = ?1 AND podcast_id = ?2", nativeQuery = true)
    void deleteRec(Long userId, Long podcastId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USERS_WATCHED_EPISODES (USER_ID, EPISODE_ID) VALUES(?1, ?2)", nativeQuery = true)
    void addEpToUsersWatchedList(Long userid, Long episodeid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users_watched_episodes WHERE user_id = ?1 AND episode_id = ?2", nativeQuery = true)
    void deleteFromUserWatchedList(Long userId, Long episodeId);
}
