package com.bnta.just_listen_api.repositories;

import com.bnta.just_listen_api.models.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ContributorRepository extends JpaRepository<Contributor, Long> {

    // DERIVED QUERIES
    List<Contributor> findContributorByNameContainingIgnoreCase (String name);
    List<Contributor> findContributorByProfessionContainingIgnoreCase (String profession);
    List<Contributor> findContributorByIsPresenter (boolean isPresenter);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM episodes_contributors WHERE CONTRIBUTOR_ID = ?1", nativeQuery = true)
    void removeContributor(Long id);

}
