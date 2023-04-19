package com.example.handmade.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<UserRole> userRoles;

    public Role(int id, String name, Set<UserRole> accountRoleSet) {
        this.id = id;
        this.name = name;
        this.userRoles = userRoles;
    }

    public Role() {
    }

    public Set<UserRole> getAccountRoleSet() {
        return userRoles;
    }

    public void setAccountRoleSet(Set<UserRole> accountRoleSet) {
        this.userRoles = accountRoleSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
