package com.bvr.LearningProject.repository;

import com.bvr.LearningProject.model.CustomUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<CustomUser, Long> {

    List<CustomUser> findByEmail(String email);
}
