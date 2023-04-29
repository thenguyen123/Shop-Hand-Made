package com.example.handmade.repository;

import com.example.handmade.dto.AppUserDto;
import com.example.handmade.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    @Query(value = "SELECT app_user.img as img, app_user.name as name,cart.id as idCard  FROM app_user join cart on cart.id_user=app_user.id where app_user.email like :email", nativeQuery = true)
    AppUserDto findAppUsersByEmail(String email);

}
