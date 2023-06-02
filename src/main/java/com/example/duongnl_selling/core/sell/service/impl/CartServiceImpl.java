package com.example.duongnl_selling.core.sell.service.impl;

import com.example.duongnl_selling.core.sell.dto.request.ProductRequest;
import com.example.duongnl_selling.core.sell.dto.response.CartResponse;
import com.example.duongnl_selling.core.sell.dto.response.ProductResponse;
import com.example.duongnl_selling.core.sell.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    private final CartResponse cartResponse = new CartResponse();

    @Autowired
    private ModelMapper mapper;

    @Override
    public CartResponse findCart() {
        Map<ProductResponse, Integer> productMap = cartResponse.getProductCart();
        CartResponse cart = new CartResponse(productMap);
        return cart;
    }

    @Override
    public Map<ProductResponse, Integer> addToCart(ProductRequest request, int quantity) {
        ProductResponse product = mapper.map(request, ProductResponse.class);
        Map<ProductResponse, Integer> mapProducts = cartResponse.getProductCart();
        if (mapProducts.containsKey(product)) {
            int currentQuantity = mapProducts.get(product);
            mapProducts.put(product, currentQuantity + quantity);
        } else {
            mapProducts.put(product, quantity);
        }
        return mapProducts;
    }

}
