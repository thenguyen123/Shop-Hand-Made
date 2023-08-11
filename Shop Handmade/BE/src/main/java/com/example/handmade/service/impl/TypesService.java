package com.example.handmade.service.impl;

import com.example.handmade.model.Types;
import com.example.handmade.repository.ITypesRepository;
import com.example.handmade.service.ITypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesService implements ITypesService {
    @Autowired
    private ITypesRepository iTypesRepository;
    @Override
    public List<Types> findAllTypes() {
        return iTypesRepository.findAll();
    }
}
