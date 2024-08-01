package com.bvr.LearningProject.controller;

import com.bvr.LearningProject.model.Roles;
import com.bvr.LearningProject.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "role")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> saveRale(@RequestBody Roles roles){
        Roles saveRole = rolesService.saveRole(roles);
        if (saveRole!=null){
            return new ResponseEntity<>("Save Successfully with Role id : "+saveRole.getId(),HttpStatus.CREATED);
        }
        return new ResponseEntity<>("unsuccessfully! ", HttpStatus.CONFLICT);
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<?> getAllRales(){
        List<Roles> allRoles = rolesService.getAllRoles();
        if (allRoles!=null&&!allRoles.isEmpty()){
            return new ResponseEntity<>(allRoles,HttpStatus.OK);
        }
        return new ResponseEntity<>("No Role available now !!!! ", HttpStatus.CONFLICT);
    }
}
