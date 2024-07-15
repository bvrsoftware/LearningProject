package com.bvr.LearningProject.services;

import com.bvr.LearningProject.model.CustomUser;
import com.bvr.LearningProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class customUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password;
        List<GrantedAuthority> authorities;
        List<CustomUser> userList = userRepository.findByEmail(username);
        if (userList.isEmpty()){
            throw  new UsernameNotFoundException("User details not found for the user : " + username);
        }else {
            userName = userList.get(0).getEmail();
            password = userList.get(0).getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(userList.get(0).getRole()));
        }
        return new User(userName,password,authorities);
    }
}
