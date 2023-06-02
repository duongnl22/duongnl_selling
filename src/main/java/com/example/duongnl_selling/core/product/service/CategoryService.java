package com.example.duongnl_selling.core.product.service;

import com.example.duongnl_selling.core.product.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> findAll();
}
