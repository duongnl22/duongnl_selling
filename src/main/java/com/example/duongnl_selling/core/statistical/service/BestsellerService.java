package com.example.duongnl_selling.core.statistical.service;

import com.example.duongnl_selling.core.statistical.dto.response.CartResponse;

import java.util.List;

public interface BestsellerService {

    List<CartResponse> getBestSeller(String date);

    List<CartResponse> getTop10();

}
