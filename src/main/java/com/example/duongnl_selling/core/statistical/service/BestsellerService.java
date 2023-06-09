package com.example.duongnl_selling.core.statistical.service;

import com.example.duongnl_selling.core.statistical.dto.response.CartResponse;
import com.example.duongnl_selling.core.statistical.dto.response.ProductResponse;

import java.util.List;

public interface BestsellerService {

    List<CartResponse> getBestSeller();

}
