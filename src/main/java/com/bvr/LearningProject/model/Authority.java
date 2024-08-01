package com.bvr.LearningProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "authority")
@Getter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;
    @Column(name = "aName")
    private String authorityName;

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName.toUpperCase();
    }
}
