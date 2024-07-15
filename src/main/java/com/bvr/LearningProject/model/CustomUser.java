package com.bvr.LearningProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


@Getter
@Setter
@Entity
@Table(name = "customer")
public class CustomUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    private String email;
    private String pwd;
    private String role;

}
