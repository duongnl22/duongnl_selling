package com.example.duongnl_selling.core.product.service;

import com.example.duongnl_selling.core.product.dto.request.CreateProductRequest;
import com.example.duongnl_selling.core.product.dto.request.UpdateProductRequest;
import com.example.duongnl_selling.core.product.dto.response.ProductResponse;
import com.example.duongnl_selling.entity.Product;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    //    List<ProductResponse> findAll();
//
    List<ProductResponse> findProduct(boolean isDeleted);

    Product save(CreateProductRequest request);

    Product update(UpdateProductRequest request);

    Product delete(Long id);

    Product findById(Long id);

    Page<Product> paging(boolean isDeleted, int currentPage, int pageSize);

    List<Product> searchPrice(BigDecimal min, BigDecimal max);

    List<Product> searchAll(String category, String name, String connect, String resolution);

    List<Product> searchName(String name);
}
