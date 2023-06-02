package com.example.duongnl_selling.core.product.service.impl;

import com.example.duongnl_selling.infrastructure.constant.Delete;
import com.example.duongnl_selling.core.product.dto.request.CreateProductRequest;
import com.example.duongnl_selling.core.product.dto.request.UpdateProductRequest;
import com.example.duongnl_selling.core.product.dto.response.ProductResponse;
import com.example.duongnl_selling.repository.ProductRepository;
import com.example.duongnl_selling.core.product.service.ProductService;
import com.example.duongnl_selling.entity.Category;
import com.example.duongnl_selling.entity.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    //
//    @Override
//    public List<ProductResponse> findAll() {
//        List<Product> listProduct = productRepository.findAll();
//
//        TypeToken<List<ProductResponse>> typeToken = new TypeToken<>() {
//        };
//
//        List<ProductResponse> listProductResponse = mapper.map(listProduct, typeToken.getType());
//
//        return listProductResponse;
//    }
//
    @Override
    public List<ProductResponse> findProduct(boolean isDeleted) {
        List<Product> listProduct = productRepository.findProductDelete(isDeleted);

        TypeToken<List<ProductResponse>> typeToken = new TypeToken<>() {
        };

        List<ProductResponse> listProductResponse = mapper.map(listProduct, typeToken.getType());

        return listProductResponse;
    }

    @Override
    public Product save(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        product.setPriceDiscount(request.getPriceDiscount());
        product.setResolution(request.getResolution());
        product.setConnect(request.getConnect());
        product.setImage(request.getImage());
        product.setCreateDate(LocalDate.now());
        product.setIsDeleted(Delete.UNDELETED.getDelete());
        Category category = mapper.map(request.getCategory(), Category.class);
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product update(UpdateProductRequest request) {
        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        product.setPriceDiscount(request.getPriceDiscount());
        product.setResolution(request.getResolution());
        product.setConnect(request.getConnect());
        product.setImage(request.getImage());
        product.setCreateDate(request.getCreateDate());
        product.setIsDeleted(Delete.UNDELETED.getDelete());
        Category category = mapper.map(request.getCategory(), Category.class);
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product delete(Long id) {
        Product product = productRepository.findById(id).get();
        product.setIsDeleted(Delete.DELETED.getDelete());
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Page<Product> paging(boolean isDeleted, int currentPage, int pageSize) {
        Page<Product> pageProduct = productRepository.findProduct(isDeleted, PageRequest.of(currentPage, pageSize));
        return pageProduct;
    }

    @Override
    public List<Product> searchPrice(BigDecimal min, BigDecimal max) {
        return productRepository.searchPrice(false, min, max);
    }

    @Override
    public List<Product> searchAll(String category, String name, String connect, String resolution) {
        return null;
    }

    @Override
    public List<Product> searchName(String name) {
        return productRepository.findByNameContains(name);
    }


}
