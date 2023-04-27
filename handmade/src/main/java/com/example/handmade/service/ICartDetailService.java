package com.example.handmade.service;

import com.example.handmade.model.CartDetail;

import java.util.List;

public interface ICartDetailService {
    void save(CartDetail cartDetail);
    List<CartDetail> findAll();
}
