package com.example.handmade.service.impl;

import com.example.handmade.model.CartDetail;
import com.example.handmade.repository.ICartDetailRepository;
import com.example.handmade.service.ICartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService implements ICartDetailService {
    @Autowired
    private ICartDetailRepository iCartDetailRepository;

    @Override
    public void save(CartDetail cartDetail) {
        iCartDetailRepository.save(cartDetail);

    }

    @Override
    public List<CartDetail> findAll() {
        return iCartDetailRepository.findAll();
    }
}
