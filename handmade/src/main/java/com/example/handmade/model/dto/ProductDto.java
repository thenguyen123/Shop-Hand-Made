package com.example.handmade.model.dto;

import com.example.handmade.model.Image;
import com.example.handmade.model.Product;

public class ProductDto {
    private Product product;
    private Image img;

    public ProductDto() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
