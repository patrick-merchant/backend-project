package com.bnta.just_listen_api.repositories;

import com.bnta.just_listen_api.models.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributorRepository extends JpaRepository<Contributor, Long> {
}
