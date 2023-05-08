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
    public void payPal(Long id, String dayPayPal) {
        List<CartDetail> list = iCartDetailRepository.findByIdCart(id);
        for (int i = 0; i < list.size(); i++) {
            Long idProduct = list.get(i).getProduct().getId();
            int amount = list.get(i).getAmount();
            Product product = iProductService.findById(idProduct);
            product.setQuantity(product.getQuantity() - amount);
            iProductService.save(product);
        }
        iCartDetailRepository.payPal(id, dayPayPal);
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
