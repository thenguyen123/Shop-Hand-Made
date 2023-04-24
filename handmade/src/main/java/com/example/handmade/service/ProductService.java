package com.example.handmade.service;

import com.example.handmade.dto.ProductDto;
import com.example.handmade.model.Image;
import com.example.handmade.model.Product;
import com.example.handmade.repository.IProductRepository;
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
    public Page<ProductDto> findAll(Pageable pageable) {
        Page<Product> page = iProductRepository.findAll(pageable);

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
    public Product findById(long id) {
        return iProductRepository.findById(id);
    }
}
