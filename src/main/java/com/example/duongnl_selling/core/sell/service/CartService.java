package com.example.duongnl_selling.core.sell.service;

import com.example.duongnl_selling.core.sell.dto.request.ProductRequest;
import com.example.duongnl_selling.core.sell.dto.response.CartResponse;
import com.example.duongnl_selling.core.sell.dto.response.ProductResponse;
import com.example.duongnl_selling.entity.Product;

import java.util.Map;

public interface CartService {

    CartResponse findCart();
    Map<ProductResponse, Integer> addToCart(ProductRequest product , int quantity);
}
