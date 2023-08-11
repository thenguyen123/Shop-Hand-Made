package com.example.handmade.service;

import com.example.handmade.dto.AppUserDto;
import com.example.handmade.model.AppUser;

public interface IAppUserService {
    AppUserDto findByEmail(String name);
}
