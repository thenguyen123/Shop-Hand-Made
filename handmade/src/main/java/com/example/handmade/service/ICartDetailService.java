package com.example.handmade.service;

import com.example.handmade.model.CartDetail;

import java.util.List;

public interface ICartDetailService {
    boolean save(CartDetail cartDetail);
    List<CartDetail> findAll();
}
