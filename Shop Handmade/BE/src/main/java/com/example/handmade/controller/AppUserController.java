package com.example.handmade.controller;

import com.example.handmade.dto.AppUserDto;
import com.example.handmade.model.AppUser;
import com.example.handmade.repository.IAppUserRepository;
import com.example.handmade.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/public")
public class AppUserController {
    @Autowired
    private IAppUserService iAppUserService;
    @GetMapping("appUser")
    public ResponseEntity getAll(@RequestParam String email){
        AppUserDto appUser = iAppUserService.findByEmail(email);
        return new ResponseEntity(appUser, HttpStatus.OK);
    }
}
