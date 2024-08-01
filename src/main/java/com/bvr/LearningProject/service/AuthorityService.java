package com.bvr.LearningProject.service;

import com.bvr.LearningProject.model.Authority;
import com.bvr.LearningProject.repository.AuthorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepo authorityRepo;


    public Authority saveAuthority(Authority authority) {
        return authorityRepo.save(authority);
    }

    public Authority getAuthorityById(Long id) {
        return authorityRepo.findById(id).orElse(null);
    }

    public Authority getAuthorityByName(String name) {
        return authorityRepo.findByAuthorityName(name.toUpperCase()).orElse(null);
    }
    public List<Authority> getAllAuthority(){
        return authorityRepo.findAll();
    }
}
