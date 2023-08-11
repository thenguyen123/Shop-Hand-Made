package com.example.handmade.service;

import com.example.handmade.model.AppUser;
import org.springframework.data.repository.query.Param;

public interface IAccountService {
    AppUser findAccountByEmployeeEmail(String username) ;


}
