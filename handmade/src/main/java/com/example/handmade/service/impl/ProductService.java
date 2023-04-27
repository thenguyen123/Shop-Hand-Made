package com.example.handmade.service.impl;

import com.example.handmade.dto.ProductCartDto;
import com.example.handmade.dto.ProductDto;
import com.example.handmade.model.Image;
import com.example.handmade.model.Product;
import com.example.handmade.repository.IProductRepository;
import com.example.handmade.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Product findById(long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Page<ProductDto> searchByName(Pageable pageable, String name) {
        Page<Product> page = iProductRepository.searchByName(pageable, name);

        Page<ProductDto> page1 ;
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p : page.getContent()) {
            ProductDto productDto=new ProductDto();
            productDto.setProduct(p);
            Set<Image> set= p.getImage();
            List<Image> images=new ArrayList<>(set);
            if(!images.isEmpty()){
                productDto.setImg(images.get(0));
            }

            productDtos.add(productDto);
        }

        page1 = new PageImpl<>(productDtos,page.getPageable(),page.getTotalElements());

        return page1;
    }

    @Override
    public Page<ProductDto> searchByNameAndType(Pageable pageable, String name, int idTypes) {
        Page<Product> page = iProductRepository.searchByNameAndTypes(pageable, name,idTypes);
        Page<ProductDto> page1 ;
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product p : page.getContent()) {
            ProductDto productDto=new ProductDto();
            productDto.setProduct(p);
            Set<Image> set= p.getImage();
            List<Image> images=new ArrayList<>(set);
            productDto.setImg(images.get(0));
            productDtos.add(productDto);
        }

        page1 = new PageImpl<>(productDtos,page.getPageable(),page.getTotalElements());
        return page1;
    }


    @Override
    public Page<ProductCartDto> findCart(String userName, Pageable pageable) {
        return  iProductRepository.findCart(userName, pageable);

    }



}
