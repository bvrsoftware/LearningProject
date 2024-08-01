package com.bvr.LearningProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;
    @Column(name = "rName")
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    Set<Customer> customers=new HashSet<>();

    public void setRoleName(String roleName) {
        this.roleName = roleName.toUpperCase();
    }
}
