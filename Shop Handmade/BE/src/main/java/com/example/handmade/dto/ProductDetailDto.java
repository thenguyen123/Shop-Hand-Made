package com.example.handmade.dto;

import com.example.handmade.model.Image;
import com.example.handmade.model.Product;

import java.util.List;

public class ProductDetailDto {
    private Product product;
    private List<Image> imageList;

    public ProductDetailDto() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}
