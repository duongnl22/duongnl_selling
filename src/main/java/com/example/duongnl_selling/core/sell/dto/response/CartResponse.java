package com.example.duongnl_selling.core.sell.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponse {

    private Long id;

    private Integer quantity;

    private BillResponse bill;

    private ProductCartResponse product;

}
