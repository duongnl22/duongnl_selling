package com.example.duongnl_selling.core.sell.service;

import com.example.duongnl_selling.core.sell.dto.request.CartSessionRequest;
import com.example.duongnl_selling.core.sell.dto.response.CartSessionResponse;

public interface CartService {

    CartSessionResponse getCart();
    String addToCart(CartSessionRequest cartSessionRequest);

    String reduceProduct(CartSessionRequest cartSessionRequest);

    String deleteProduct(Long id);

    String deleteAllProduct();
}
