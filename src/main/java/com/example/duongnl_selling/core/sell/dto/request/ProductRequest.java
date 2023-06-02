package com.example.duongnl_selling.core.sell.dto.request;

import com.example.duongnl_selling.core.product.dto.response.CategoryResponse;
import com.example.duongnl_selling.entity.Product;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductRequest {

    private Long id;
    private String name;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal priceDiscount;
    private Integer resolution;
    private String connect;
    private String image;
    private String description;
    private Boolean isDeleted;
    private CategoryResponse category;



}
