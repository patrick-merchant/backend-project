package com.bnta.just_listen_api.repositories;

import com.bnta.just_listen_api.models.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContributorRepository extends JpaRepository<Contributor, Long> {

    // DERIVED QUERIES
    List<Contributor> findContributorByNameContainingIgnoreCase (String name);
    List<Contributor> findContributorByProfessionContainingIgnoreCase (String profession);
    List<Contributor> findContributorByIsPresenter (boolean isPresenter);

}
