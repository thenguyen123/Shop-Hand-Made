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
    public boolean save(CartDetail cartDetail) {
        cartDetail.setFlag(false);
        List<CartDetail> cartDetails =findAll();


        for (int i = 0; i < cartDetails.size(); i++) {

            if (cartDetails.get(i).getProduct().getId() == cartDetail.getProduct().getId() && cartDetails.get(i).getCart().getId() == cartDetail.getCart().getId()) {
                cartDetail.setId(cartDetails.get(i).getId());
              cartDetail.setAmount( cartDetails.get(i).getAmount()+ cartDetail.getAmount());
                iCartDetailRepository.save(cartDetail);
                return true;
            }
        }
        iCartDetailRepository.save(cartDetail);
        return true;
    }

    @Override
    public List<CartDetail> findAll() {

        return iCartDetailRepository.findAll();
    }
}
