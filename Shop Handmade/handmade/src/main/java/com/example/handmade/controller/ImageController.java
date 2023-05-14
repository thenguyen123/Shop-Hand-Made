package com.example.handmade.controller;

import com.example.handmade.model.Image;
import com.example.handmade.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/image")
public class ImageController {
    @Autowired
    private IImageService iImageService;
    @GetMapping("list")
    public ResponseEntity findAll(){
        List<Image> list=iImageService.findAll();
        if(list.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
