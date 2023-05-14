package com.example.handmade.repository;

import com.example.handmade.dto.AppUserDto;
import com.example.handmade.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    @Query(value = "SELECT app_user.img as img,app_user.day_of_birth as dayOfBirth,app_user.phone_number as phone,app_user.email as email,app_user.gender as gender," +
            "app_user.address as address, app_user.name as name,cart.id as idCard  FROM app_user join cart on cart.id_user=app_user.id where app_user.email like :email", nativeQuery = true)
    AppUserDto findAppUsersByEmail(String email);

}
