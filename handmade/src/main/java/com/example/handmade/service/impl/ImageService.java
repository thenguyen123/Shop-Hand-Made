package com.example.handmade.service.impl;

import com.example.handmade.model.Image;
import com.example.handmade.repository.IImageRepository;
import com.example.handmade.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageService implements IImageService {
    @Autowired
    private IImageRepository iImageRepository;
    @Override
    public List<Image> findAll() {
        return iImageRepository.findAll();
    }
}
