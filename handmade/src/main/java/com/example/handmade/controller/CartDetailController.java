package com.example.handmade.controller;

import com.example.handmade.model.CartDetail;
import com.example.handmade.service.ICartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/public")
public class CartDetailController {
    @Autowired
    private ICartDetailService iCartDetailService;

    @GetMapping("cart/add")
    public ResponseEntity addToCart(@RequestParam long id, @RequestBody CartDetail cartDetail) {
        if (cartDetail == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        iCartDetailService.save(cartDetail);
        return new ResponseEntity(HttpStatus.OK);
    }
}
