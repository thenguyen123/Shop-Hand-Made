package com.example.handmade.service.impl;

import com.example.handmade.model.AppUser;
import com.example.handmade.repository.IAppUserRepository;
import com.example.handmade.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements IAppUserService {
    @Autowired
    private IAppUserRepository iAppUserRepository;
    @Override
    public AppUser findByEmail(String name) {
        return null;
    }
}
