package com.bvr.LearningProject.service;

import com.bvr.LearningProject.model.Roles;
import com.bvr.LearningProject.repository.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {
    @Autowired
    private RolesRepo rolesRepo;

    public Roles saveRole(Roles roles) {
        return rolesRepo.save(roles);
    }

    public Roles getRoleById(Long id) {
        return rolesRepo.findById(id).orElse(null);
    }

    public Roles getRoleByName(String name) {
        return rolesRepo.findByRoleName(name.toUpperCase()).orElse(null);
    }
    public List<Roles> getAllRoles(){
        return rolesRepo.findAll();
    }
}
