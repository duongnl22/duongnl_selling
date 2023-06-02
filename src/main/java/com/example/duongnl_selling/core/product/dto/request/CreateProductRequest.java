package com.example.duongnl_selling.core.product.dto.request;

import com.example.duongnl_selling.core.product.dto.response.CategoryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    private String name;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal priceDiscount;
    private Integer resolution;
    private Boolean connect;
    private String image;
    private LocalDate createDate;
    private CategoryResponse category;
}
