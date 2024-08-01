package com.bvr.LearningProject.controller;

import com.bvr.LearningProject.model.Authority;
import com.bvr.LearningProject.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "authority")
public class AuthorityController {
    @Autowired
    private AuthorityService authorityService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<?> saveAuthority(@RequestBody Authority authority){
        Authority saveAuthority = authorityService.saveAuthority(authority);
        if (saveAuthority!=null){
            return new ResponseEntity<>("Save Authority Successfully with id : "+saveAuthority.getId(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("unsuccessfully! ", HttpStatus.CONFLICT);
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<?> getAllAuthorities(){
        List<Authority> allAuthority = authorityService.getAllAuthority();
        if (allAuthority!=null&&!allAuthority.isEmpty()){
            return new ResponseEntity<>(allAuthority,HttpStatus.OK);
        }
        return new ResponseEntity<>("No Authority available now !!!! ", HttpStatus.CONFLICT);
    }
}
