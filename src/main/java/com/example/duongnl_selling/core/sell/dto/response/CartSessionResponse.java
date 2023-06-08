package com.example.duongnl_selling.core.sell.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartSessionResponse {

    private List<ProductCartResponse> listProduct = new ArrayList<>();

    private BigDecimal intoMoney ;

}
