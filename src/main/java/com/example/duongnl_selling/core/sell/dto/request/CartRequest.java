package com.example.duongnl_selling.core.sell.dto.request;

import com.example.duongnl_selling.core.sell.dto.response.BillResponse;
import com.example.duongnl_selling.core.sell.dto.response.CartSessionResponse;
import com.example.duongnl_selling.core.sell.dto.response.ProductCartResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartRequest {

    private BillResponse bill;

    private List<ProductCartResponse> product = new ArrayList<>();

}
