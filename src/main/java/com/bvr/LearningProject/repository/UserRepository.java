package com.bvr.LearningProject.repository;

import com.bvr.LearningProject.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {

    List<CustomUser> findByEmail(String email);
}
