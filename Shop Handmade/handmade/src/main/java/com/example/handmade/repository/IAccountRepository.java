package com.example.handmade.repository;

import com.example.handmade.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAccountRepository extends JpaRepository<AppUser,Long> {
    @Query(value = "select * from app_user where email=:email", nativeQuery = true)
    AppUser findAccountByEmployeeEmail(@Param("email") String username);
}
