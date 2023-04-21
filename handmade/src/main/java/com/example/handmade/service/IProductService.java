package com.example.handmade.service;

import com.example.handmade.model.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductDto> findAll(Pageable pageable);
}
