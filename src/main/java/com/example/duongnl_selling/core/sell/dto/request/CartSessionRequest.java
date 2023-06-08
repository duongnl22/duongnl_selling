package com.example.duongnl_selling.core.sell.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartSessionRequest {

    private Long id;
    private Integer quantity;


}
