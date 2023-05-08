package com.example.handmade.service;

import com.example.handmade.dto.CartDetailDto;
import com.example.handmade.dto.ProductCartDto;
import com.example.handmade.model.CartDetail;

import java.util.List;

public interface ICartDetailService {
    boolean save(CartDetail cartDetail);

    List<CartDetail> findAll();

    CartDetail findById(Long id);

    void changeAmount(CartDetail cartDetail);

    void deleteCartDetail(CartDetail cartDetail);
    void payPal(Long id, String dayPayPal);
    List<ProductCartDto> findCart(String userName);
    List<CartDetailDto> findBuy(String userName);

}
