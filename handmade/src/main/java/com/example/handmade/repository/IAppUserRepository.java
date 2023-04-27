package com.example.handmade.repository;

import com.example.handmade.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findAppUsersByEmail(String email);

}
