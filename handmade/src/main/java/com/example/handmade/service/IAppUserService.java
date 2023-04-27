package com.example.handmade.service;

import com.example.handmade.model.AppUser;

public interface IAppUserService {
    AppUser findByEmail(String name);
}
