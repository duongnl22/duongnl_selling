package com.example.duongnl_selling.core.statistical.service.impl;

import com.example.duongnl_selling.core.statistical.dto.response.CartResponse;
import com.example.duongnl_selling.core.statistical.dto.response.ProductResponse;
import com.example.duongnl_selling.core.statistical.service.BestsellerService;
import com.example.duongnl_selling.entity.Product;
import com.example.duongnl_selling.repository.CartRepository;
import com.example.duongnl_selling.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<CartResponse> getBestSeller() {
        List<Object[]> listCart = cartRepository.getTop10BestSeller();
        List<CartResponse> listCartResponse = new ArrayList<>();
        for (Object[] object : listCart) {
            Long idProduct = (Long) object[0];
            Long count = (Long) object[1];

            ProductResponse productResponse = findProduct(idProduct);
            listCartResponse.add(new CartResponse(productResponse, count));
        }

        return listCartResponse;
    }


    private ProductResponse findProduct(Long id) {
        Product product = productRepository.findById(id).get();
        return mapper.map(product, ProductResponse.class);
    }
}
