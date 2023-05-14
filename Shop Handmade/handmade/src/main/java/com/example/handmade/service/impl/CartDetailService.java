package com.example.handmade.service.impl;

import com.example.handmade.dto.CartDetailDto;
import com.example.handmade.dto.ProductCartDto;
import com.example.handmade.model.CartDetail;
import com.example.handmade.model.Product;
import com.example.handmade.repository.ICartDetailRepository;
import com.example.handmade.service.ICartDetailService;
import com.example.handmade.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService implements ICartDetailService {
    @Autowired
    private ICartDetailRepository iCartDetailRepository;
    @Autowired
    private IProductService iProductService;


    @Override
    public boolean save(CartDetail cartDetail) {
        cartDetail.setFlag(false);
        List<CartDetail> cartDetails = findAll();
        for (int i = 0; i < cartDetails.size(); i++) {
            if (cartDetails.get(i).getProduct().getId() == cartDetail.getProduct().getId() && cartDetails.get(i).getCart().getId() == cartDetail.getCart().getId()) {
                cartDetail.setId(cartDetails.get(i).getId());
                cartDetail.setAmount(cartDetails.get(i).getAmount() + cartDetail.getAmount());
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

    @Override
    public CartDetail findById(Long id) {
        return iCartDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void changeAmount(CartDetail cartDetail) {
        iCartDetailRepository.save(cartDetail);
    }

    @Override
    public void deleteCartDetail(CartDetail cartDetail) {
        iCartDetailRepository.delete(cartDetail);
    }

    @Override
    public boolean payPal(Long idCartDetail, String dayPayPal) {
        CartDetail cartDetail= iCartDetailRepository.findById(idCartDetail).orElse(null);
        Product product= iProductService.findById(cartDetail.getProduct().getId());
        if(product.getQuantity() - cartDetail.getAmount()<0){
            return false;
        }
            product.setQuantity(product.getQuantity() - cartDetail.getAmount());
            iProductService.save(product);
            iCartDetailRepository.payPal(idCartDetail, dayPayPal);
            return true;
    }

    @Override
    public List<ProductCartDto> findCart(String userName) {
        return iCartDetailRepository.findCart(userName);
    }

    @Override
    public List<CartDetailDto> findBuy(String userName) {
        return iCartDetailRepository.findBuy(userName);
    }


}
