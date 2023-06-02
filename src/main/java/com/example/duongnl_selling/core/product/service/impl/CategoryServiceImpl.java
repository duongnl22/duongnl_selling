package com.example.duongnl_selling.core.product.service.impl;

import com.example.duongnl_selling.core.product.dto.response.CategoryResponse;
import com.example.duongnl_selling.repository.CategoryRepository;
import com.example.duongnl_selling.core.product.service.CategoryService;
import com.example.duongnl_selling.entity.Category;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<CategoryResponse> findAll() {
        List<Category> listCategory = categoryRepository.findAll();
        TypeToken<List<CategoryResponse>> typeToken = new TypeToken<>() {
        };
        List<CategoryResponse> listCategoryResponse = mapper.map(listCategory, typeToken.getType());
        return listCategoryResponse;
    }
}
