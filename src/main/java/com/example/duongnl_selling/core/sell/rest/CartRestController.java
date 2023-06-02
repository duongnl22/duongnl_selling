package com.example.duongnl_selling.core.sell.rest;

import com.example.duongnl_selling.core.sell.dto.request.ProductRequest;
import com.example.duongnl_selling.core.sell.dto.response.CartResponse;
import com.example.duongnl_selling.core.sell.dto.response.ProductResponse;
import com.example.duongnl_selling.core.sell.service.CartService;
import com.example.duongnl_selling.infrastructure.config.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseObject findCart() {
        return new ResponseObject(cartService.findCart());
    }

    @PostMapping("/add-cart")
    public ResponseObject addToCart(@RequestBody ProductRequest request) {
        return new ResponseObject(cartService.addToCart(request,1));
    }
}
