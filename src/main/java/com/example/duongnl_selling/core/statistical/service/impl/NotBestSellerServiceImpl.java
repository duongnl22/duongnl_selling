package com.example.duongnl_selling.core.statistical.service.impl;

import com.example.duongnl_selling.core.statistical.dto.response.ProductResponse;
import com.example.duongnl_selling.core.statistical.service.NotBestSellerService;
import com.example.duongnl_selling.entity.Product;
import com.example.duongnl_selling.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotBestSellerServiceImpl implements NotBestSellerService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public List<ProductResponse> getNotBestSeller() {
        List<Product> listProduct = productRepository.getTop10NotBestSeller();
        TypeToken<List<ProductResponse>> typeToken = new TypeToken<>(){};

        return mapper.map(listProduct, typeToken.getType());
    }
}
