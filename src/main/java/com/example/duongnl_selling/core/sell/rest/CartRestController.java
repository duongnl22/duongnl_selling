package com.example.duongnl_selling.core.sell.rest;

import com.example.duongnl_selling.core.sell.dto.request.CartSessionRequest;
import com.example.duongnl_selling.core.sell.service.CartService;
import com.example.duongnl_selling.infrastructure.config.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

@CrossOrigin
@RestController
@RequestMapping("/cart")
@SessionScope
public class CartRestController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseObject findCart() {
        return new ResponseObject(cartService.getCart());
    }

    @PostMapping("/add-to-cart")
    public ResponseObject addToCart(@RequestBody CartSessionRequest request) {
        return new ResponseObject(cartService.addToCart(request));
    }

    @PostMapping("/reduce")
    public ResponseObject reduceProduct(@RequestBody CartSessionRequest request) {
        return new ResponseObject(cartService.reduceProduct(request));
    }

    @GetMapping("/delete/{id}")
    public ResponseObject deleteProduct(@PathVariable("id") Long id) {
        return new ResponseObject(cartService.deleteProduct(id));
    }

    @GetMapping("/delete-all")
    public ResponseObject deleteAll() {
        return new ResponseObject(cartService.deleteAllProduct());
    }
}
