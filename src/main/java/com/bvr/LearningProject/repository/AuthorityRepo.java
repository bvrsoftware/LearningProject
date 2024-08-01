package com.bvr.LearningProject.repository;

import com.bvr.LearningProject.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepo extends JpaRepository<Authority,Long> {
    Optional<Authority> findByAuthorityName(String aName);
}
