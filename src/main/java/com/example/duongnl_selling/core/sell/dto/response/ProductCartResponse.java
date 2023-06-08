package com.example.duongnl_selling.core.sell.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductCartResponse {
    private Long id;
    private String name;
    private Integer quantity;
    private String image;
    private BigDecimal price;
    private BigDecimal totalPrice;

}
