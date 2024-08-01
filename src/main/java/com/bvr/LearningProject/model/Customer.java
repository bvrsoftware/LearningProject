package com.bvr.LearningProject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer")
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "num")
    private String number;
    @Column(name = "mail")
    private String email;
    @Column(name = "pass")
    private String password;

    //TODO its work for one to OneToOne mapping
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;

    //TODO its work for one to OneToMany mapping
//    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
//    @JoinColumn(name = "customer_id", referencedColumnName = "id")
//    private Set<Address> addresses = new HashSet<>();
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name = "customer_role",
            joinColumns = @JoinColumn(name = "customer_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<Roles> roles = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id.equals(customer.id) && name.equals(customer.name) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
