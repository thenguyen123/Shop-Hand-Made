package com.example.handmade.controller;

import com.example.handmade.dto.ProductDetailDto;
import com.example.handmade.model.Image;
import com.example.handmade.model.Product;
import com.example.handmade.dto.ProductDto;
import com.example.handmade.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("list")
    public ResponseEntity findAll(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDto> page1 = iProductService.findAll(pageable);

        if (page1.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(page1, HttpStatus.OK);
    }

    @GetMapping("detail")
    public ResponseEntity findById(@RequestParam long id) {
        Product product = iProductService.findById(id);
        List<Image> images= new ArrayList<>(product.getImage());
        ProductDetailDto productDto= new ProductDetailDto();
        productDto.setProduct(product);
        productDto.setImageList(images);
        if (productDto == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(productDto, HttpStatus.OK);
    }
}
