package com.example.handmade.controller;

import com.example.handmade.dto.CartDetailDto;
import com.example.handmade.dto.ProductCartDto;
import com.example.handmade.model.CartDetail;
import com.example.handmade.service.ICartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.RandomValuePropertySourceEnvironmentPostProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class CartDetailController {
    @Autowired
    private ICartDetailService iCartDetailService;

    @PostMapping("cart/add")
    public ResponseEntity addToCart( @RequestBody CartDetail cartDetail) {
        if (cartDetail == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        iCartDetailService.save(cartDetail);
        return new ResponseEntity(HttpStatus.OK);
        
    }
    @PostMapping("cart/fastBuy")
    public ResponseEntity fastBuy( @RequestBody CartDetail cartDetail) {
        if (cartDetail == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatterDay=dateTimeFormatter.format(date);
        iCartDetailService.save(cartDetail);
        iCartDetailService.payPal(cartDetail.getId(),formatterDay );
        return new ResponseEntity(HttpStatus.OK);

    }
    @GetMapping("cart/add2")
    public ResponseEntity addToCart2(@RequestParam Long id, @RequestParam int amount){
        CartDetail  cartDetail= iCartDetailService.findById(id);
    if (cartDetail==null){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    cartDetail.setAmount(amount);
    iCartDetailService.changeAmount(cartDetail);
    return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("cart/delete")
    public ResponseEntity delete(@RequestParam Long id){
        CartDetail cartDetail= iCartDetailService.findById(id);
        if (cartDetail==null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }iCartDetailService.deleteCartDetail(cartDetail);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("payPal")
    public ResponseEntity payPal(@RequestParam Long idCartDetail){
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatterDay=dateTimeFormatter.format(date);
      boolean flag=  iCartDetailService.payPal(idCartDetail,formatterDay);
      if(flag){
          return new ResponseEntity(HttpStatus.OK);
      }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("cart")
    public ResponseEntity findCard(@RequestParam String userName) {
        List<ProductCartDto> productDto = iCartDetailService.findCart(userName);
        if (productDto == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(productDto, HttpStatus.OK);
    }
    @GetMapping("cart/history")
    public ResponseEntity findBuy(@RequestParam() String userName) {
        List<CartDetailDto> productDto = iCartDetailService.findBuy(userName);
        if (productDto == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(productDto, HttpStatus.OK);
    }
}
