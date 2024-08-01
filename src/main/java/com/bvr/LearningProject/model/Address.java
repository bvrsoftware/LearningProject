package com.bvr.LearningProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Setter
@Getter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "addLn1")
    private String address;
    @Column(name = "dist")
    private String district;
    @Column(name = "state")
    private String state;
    @Column(name = "pin")
    private Integer postPin;

    //TODO its work for one to OneToOne mapping
//    @JsonIgnore
//    @OneToOne(mappedBy = "address")
//    private Customer customer;

    //TODO its work for one to OneToMany mapping
//    @Column(name = "customer_id")
//    private Long customerId;
}
