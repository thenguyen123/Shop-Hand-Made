package com.example.handmade.model;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private AppUser appUser;

    public UserRole() {
    }

    public UserRole(long id, Role role, AppUser appUser) {
        this.id = id;
        this.role = role;
        this.appUser = appUser;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
