package com.example.duongnl_selling.core.sell.service;

import com.example.duongnl_selling.core.sell.dto.request.CartRequest;
import com.example.duongnl_selling.core.sell.dto.request.CreateBillRequest;
import com.example.duongnl_selling.core.sell.dto.response.BillResponse;
import com.example.duongnl_selling.core.sell.dto.response.CartResponse;
import com.example.duongnl_selling.entity.Bill;

import java.util.List;

public interface BillService {

    List<BillResponse> findByAccount(Long id );

    Bill create(CreateBillRequest request);

    String pay(CartRequest request);

    List<CartResponse> findBillDetail(Long id);

}
