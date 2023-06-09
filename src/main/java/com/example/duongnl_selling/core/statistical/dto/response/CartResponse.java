package com.example.duongnl_selling.core.statistical.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {

    private ProductResponse product;

    private Long count;


}
