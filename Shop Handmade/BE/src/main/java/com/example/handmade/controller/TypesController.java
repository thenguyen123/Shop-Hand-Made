package com.example.handmade.controller;

import com.example.handmade.model.Types;
import com.example.handmade.service.ITypesService;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/public")
public class TypesController {
    @Autowired
    private ITypesService iTypesService;

    @GetMapping("types/list")
    public ResponseEntity findTypes() {
        List<Types> list = iTypesService.findAllTypes();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
