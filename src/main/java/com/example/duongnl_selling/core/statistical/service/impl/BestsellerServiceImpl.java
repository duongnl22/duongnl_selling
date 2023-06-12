package com.example.duongnl_selling.core.statistical.service.impl;

import com.example.duongnl_selling.core.statistical.dto.response.CartResponse;
import com.example.duongnl_selling.core.statistical.service.BestsellerService;
import com.example.duongnl_selling.repository.CartRepository;
import com.example.duongnl_selling.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BestsellerServiceImpl implements BestsellerService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CartResponse> getBestSeller(String date) {
        List<Object[]> listCart = cartRepository.getBestSellerForDate(date);
        List<CartResponse> listCartResponse = new ArrayList<>();
        for (Object[] object : listCart) {
            String product = (String) object[0];
            Long count = (Long) object[1];

            listCartResponse.add(new CartResponse(product, count));


        }

        return listCartResponse;
    }

    @Override
    public List<CartResponse> getTop10() {
        List<Object[]> listCart = cartRepository.getBestSeller();
        List<CartResponse> listCartResponse = new ArrayList<>();
        for (Object[] object : listCart) {
            String product = (String) object[0];
            Long count = (Long) object[1];

            listCartResponse.add(new CartResponse(product, count));


        }

        return listCartResponse;
    }


}
