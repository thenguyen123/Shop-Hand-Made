package com.example.handmade.service;

import com.example.handmade.dto.ProductCartDto;
import com.example.handmade.model.Product;
import com.example.handmade.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Product findById(long id);

    Page<ProductDto> searchByName(Pageable pageable, String name);

    Page<ProductDto> searchByNameAndType(Pageable pageable, String name, int idTypes);
void save(Product product);



}
